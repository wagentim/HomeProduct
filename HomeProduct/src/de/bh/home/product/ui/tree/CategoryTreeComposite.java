package de.bh.home.product.ui.tree;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;

import de.bh.home.product.entity.AbstractTreeElement;
import de.bh.home.product.handler.UIHandler;
import de.bh.home.product.ui.base.AbstractTreeComposite;

public class CategoryTreeComposite extends AbstractTreeComposite
{

	public CategoryTreeComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getDisplayNodeName(AbstractTreeElement element)
	{
		return element.getName();
	}

	@Override
	protected SelectionListener getSelectionListener()
	{
		// TODO Auto-generated method stub
		return new SelectionListener()
		{
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		};
	}

}
