package de.bh.home.product.actions;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.bh.home.product.handler.MessageManager;
import de.bh.home.product.handler.UIHandler;

public class ActionLoadData implements SelectionListener
{
	private final UIHandler controller;
	
	public ActionLoadData(final UIHandler controller)
	{
		this.controller = controller;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0)
	{
		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0)
	{
		MessageManager.INSTANCE.sendMessage(IActionConstants.ACTION_LOAD, null);
	}

}
