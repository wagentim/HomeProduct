package de.bh.home.product.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import de.bh.home.product.handler.UIHandler;

public class CustomTreeComposite extends AbstractComposite
{
	private final UIHandler controller;
	private final Color white;
	
	private Tree tree;

	public CustomTreeComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style, controller);
		this.controller = controller;
		white = controller.getColorProxy().getColorWhite();
		initComposite();
	}

	private void initComposite()
	{
		GridLayout layout = new GridLayout(1, false);
		layout.marginTop = layout.marginBottom = layout.marginLeft = layout.marginRight = 0; 
		layout.marginHeight = layout.marginWidth = 0;
		GridData gd = new GridData(GridData.FILL_VERTICAL);
		this.setLayout(layout);
		this.setLayoutData(gd);
		this.setBackground(white);
		
		tree = new Tree(this, SWT.NONE);
		tree.setBackground(white);
		gd = new GridData(GridData.FILL_VERTICAL);
		tree.setLayoutData(gd);
		
		
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		// TODO Auto-generated method stub
		
	}

}
