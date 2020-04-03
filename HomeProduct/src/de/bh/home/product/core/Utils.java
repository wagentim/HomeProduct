package de.bh.home.product.core;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

import de.bh.home.product.entity.Product;

public final class Utils
{
//	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static final Path getCurrentPath()
	{
		return Paths.get(IConstants.EMPTY_STRING).toAbsolutePath();
	}
	
	public static Product parseProductFromJson(final String jsonObject, final Gson gson)
	{
		if(jsonObject == null || jsonObject.isEmpty())
		{
			return null;
		}
		
		return gson.fromJson(jsonObject, Product.class);
	}
	
}
