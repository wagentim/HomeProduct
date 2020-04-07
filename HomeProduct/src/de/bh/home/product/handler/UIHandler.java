package de.bh.home.product.handler;

import org.eclipse.swt.widgets.Display;

import de.bh.home.product.entity.Setting;
import de.bh.home.product.ui.ColorPicker;
import de.bh.home.product.ui.ImageRegister;
import de.bh.home.product.ui.MainScreen;

public class UIHandler implements IHandler
{
	private final Display display;
	private final ImageRegister imageRegister;
	private final ColorPicker colorProxy;
	private final Setting setting;
	
	public UIHandler()
	{
		this.display = new Display();
		this.imageRegister = new ImageRegister(display);
		colorProxy = new ColorPicker(display);
		
		SettingFileHandler settingHandler = new SettingFileHandler();
		settingHandler.loadSettingFromFile();
		setting = settingHandler.getSetting();
		
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

}
