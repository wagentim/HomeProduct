package de.bh.home.product.core;

import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.bh.home.product.entity.Product;
import de.bh.home.product.handler.ProductDBHandler;

public class Test
{
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	public static void main(String[] args)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		ProductDBHandler handler = new ProductDBHandler(gson);
		HashMap<String, Product> prods = handler.getAllProduct("yachao");
		
		Iterator<Product> it = prods.values().iterator();
		
		while(it.hasNext())
		{
			Product p = it.next();
			logger.info(p.getName());
		}
		
		logger.info("Total: {}", prods.keySet().size());
	}
}
