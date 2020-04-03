package de.bh.home.product.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.core.Utils;
import de.bh.home.product.db.IRowMapper;
import de.bh.home.product.db.SqliteDBHandler;
import de.bh.home.product.entity.Product;

public class ProductDBHandler implements IHandler
{
	private static final Logger logger = LoggerFactory.getLogger(ProductDBHandler.class);
	private final SqliteDBHandler sqlite = new SqliteDBHandler();
	private final Gson gson;
	
	public ProductDBHandler(final Gson gson)
	{
		this.gson = gson;
		sqlite.openDB(IConstants.DB_SQLITE_CLASS_NAME, IConstants.DB_DB_NAME);
	}
	
	public HashMap<String, Product> getAllProduct(final String table)
	{
		String query = "Select * from " + table + ";";
		logger.info("Get All Product: " + query);
		
		List<Product> products = Collections.emptyList();
		
		try
		{
			products = sqlite.executeQuery(query, new IRowMapper<Product>()
			{
				@Override
				public Product mapRow(ResultSet rs, int index) throws SQLException
				{
					String content = rs.getString(2);
					
					Product p = null;
					
					if(content != null && !content.isEmpty())
					{
						p = Utils.parseProductFromJson(content, gson);
					}
					else
					{
						logger.error("Error by parsing Product: {}", content);
					}
					
					return p;
				}

			});
			
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		Iterator<Product> it = products.iterator();
		
		HashMap<String, Product> result = new HashMap<String, Product>();
		
		while(it.hasNext())
		{
			Product prod = it.next();
			
			if( prod != null )
			{
				result.put(prod.getProduct_id(), prod);
			}
			
		}
		
		return result;
	}
	
	@Override
	public void destroy()
	{
		if(sqlite != null)
		{
			sqlite.destroyed();
		}
	}
}
