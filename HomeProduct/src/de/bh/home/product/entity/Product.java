package de.bh.home.product.entity;

import java.util.Collections;
import java.util.List;

import de.bh.home.product.core.IConstants;

public class Product
{
	private String product_id = IConstants.EMPTY_STRING;
	private String name = IConstants.EMPTY_STRING;
	private String site = IConstants.EMPTY_STRING;
	private String link = IConstants.EMPTY_STRING;
	private String price = IConstants.EMPTY_STRING;
	private String original_price = IConstants.EMPTY_STRING;
	private String status = IConstants.EMPTY_STRING;
	private List<HistoryPrice> price_history = Collections.emptyList();
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSite()
	{
		return site;
	}
	public void setSite(String site)
	{
		this.site = site;
	}
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	public String getOriginal_price()
	{
		return original_price;
	}
	public void setOriginal_price(String original_price)
	{
		this.original_price = original_price;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public List<HistoryPrice> getPrice_history()
	{
		return price_history;
	}
	public void setPrice_history(List<HistoryPrice> historyPrices)
	{
		this.price_history = historyPrices;
	}
	public String getProduct_id()
	{
		return product_id;
	}
	public void setProduct_id(String product_id)
	{
		this.product_id = product_id;
	}
	
}
