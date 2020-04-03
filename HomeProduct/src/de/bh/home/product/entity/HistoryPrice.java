package de.bh.home.product.entity;

import de.bh.home.product.core.IConstants;

public class HistoryPrice
{
	private String time = IConstants.EMPTY_STRING;
	private String price = IConstants.EMPTY_STRING;
	
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
}
