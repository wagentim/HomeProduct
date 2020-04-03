package de.bh.home.product.handler;

import java.util.Collections;
import java.util.List;

import org.eclipse.swt.widgets.Display;

import de.bh.home.product.ui.ColorPicker;
import de.bh.home.product.ui.ImageRegister;
import de.bh.home.product.ui.MainScreen;

public class UIHandler implements IHandler
{
	private final Display display;
	private final ImageRegister imageRegister;
	private final ColorPicker colorProxy;
	private final SettingFileHandler settingHandler;
	private List<String> webSite = Collections.emptyList();
	
	public UIHandler()
	{
		this.display = new Display();
		this.imageRegister = new ImageRegister(display);
		colorProxy = new ColorPicker(display);
		
		settingHandler = new SettingFileHandler();
		
		initialStart();
	}
	
	private void initialStart()
	{
		settingHandler.getWebSites();
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

	@Override
	public void destroy()
	{
		imageRegister.destroy();
	}

}
