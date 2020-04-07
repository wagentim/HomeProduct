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
	
	public static String siteNameMapping(final String input)
	{
		if(input.toLowerCase().equals("yachao"))
		{
			return "开元亚超";
		}
		else if(input.toLowerCase().equals("yachaoonline"))
		{
			return "亚超在线";
		}
		else if(input.toLowerCase().equals("goasia"))
		{
			return "东方行";
		}
		else
		{
			return "UNKNOWN";
		}
	}
}
