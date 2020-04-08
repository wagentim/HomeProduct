package de.bh.home.product.handler;

import java.util.HashMap;

import org.eclipse.swt.widgets.Display;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.bh.home.product.entity.Product;
import de.bh.home.product.entity.Setting;
import de.bh.home.product.entity.WebSiteElement;
import de.bh.home.product.ui.base.ColorPicker;
import de.bh.home.product.ui.base.ImageRegister;
import de.bh.home.product.ui.base.MainScreen;

public class UIHandler implements IHandler
{
	private final Display display;
	private final ImageRegister imageRegister;
	private final ColorPicker colorProxy;
	private final Setting setting;
	private final ProductDBHandler productDBHandler;
	
	private final HashMap<String, HashMap<String, Product>> products;
	
	public UIHandler()
	{
		this.display = new Display();
		this.imageRegister = new ImageRegister(display);
		colorProxy = new ColorPicker(display);
		
		SettingFileHandler settingHandler = new SettingFileHandler();
		settingHandler.loadSettingFromFile();
		setting = settingHandler.getSetting();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		productDBHandler = new ProductDBHandler(gson);
		products = new HashMap<String, HashMap<String, Product>>();
		
		new MainScreen(this);
	}
	
	public ColorPicker getColorProxy()
	{
		return colorProxy;
	}
	
	public ImageRegister getImageProxy()
	{
		return imageRegister;
	}
	
	public Display getDisplay()
	{
		return display;
	}
	
	public Setting getSetting()
	{
		return setting;
	}

	@Override
	public void destroy()
	{
		imageRegister.destroy();
	}
	
	public WebSiteElement[] getWebSites()
	{
		String[] webSites = getSetting().getWebSites();
		
		WebSiteElement[] result = {};
		
		if (webSites != null && webSites.length > 0)
		{

			int length = webSites.length;

			result = new WebSiteElement[length];

			for (int i = 0; i < length; i++)
			{
				result[i] = new WebSiteElement(webSites[i]);
			}
		}	
		
		return result;
	}
	
	public void loadProductFromDB(String table)
	{
		HashMap<String, Product> value = productDBHandler.getAllProduct(table);
		
		products.put(table, value);
	}
}
