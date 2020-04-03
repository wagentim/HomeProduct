package de.bh.home.product.ui;

import org.eclipse.swt.widgets.Composite;

import de.bh.home.product.handler.IMessageListener;
import de.bh.home.product.handler.MessageManager;
import de.bh.home.product.handler.UIHandler;

public abstract class AbstractComposite extends Composite implements IMessageListener
{
	
	protected final UIHandler controller;

	public AbstractComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style);
		this.controller = controller;
		MessageManager.INSTANCE.addMessageListener(this);
	}
}
