package de.bh.home.product.entity;

public class WebSiteElement extends AbstractTreeElement
{
	private final String name;
	
	public WebSiteElement(final String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

}
