package de.bh.home.product.junit;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.bh.home.product.entity.Product;
import de.bh.home.product.handler.ProductDBHandler;

class DBHandler
{
	private ProductDBHandler handler = null;
	
	@BeforeAll
	void ini()
	{
	}

	@Test
	void testGetAllProduct()
	{
		HashMap<String, Product> values = handler.getAllProduct("Test");
		System.out.println(values);
		assert (values) != null;
	}

}
