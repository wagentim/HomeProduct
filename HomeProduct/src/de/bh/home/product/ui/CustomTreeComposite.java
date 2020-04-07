package de.bh.home.product.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.core.Utils;
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
		GridData gd = new GridData(GridData.FILL_BOTH);
		this.setLayout(layout);
		this.setLayoutData(gd);
		this.setBackground(white);
		
		tree = new Tree(this, SWT.NONE);
		tree.setBackground(white);
		gd = new GridData(GridData.FILL_BOTH);
		tree.setLayoutData(gd);		
	}
	
	public TreeItem updateRootNode(String name)
	{
		TreeItem ti;
		
		if(tree.getItemCount() == 0)
		{
			ti = new TreeItem(tree, SWT.NONE);
		}
		else
		{
			ti = tree.getItem(0);
		}
		
		ti.setText(name);
		
		return ti;
	}
	
	public void updateChildrenNodes(String[] list)
	{
		if( list == null || list.length == 0 )
		{
			return;
		}
		
		TreeItem ti = tree.getItem(0);
		
		if( ti == null )
		{
			ti = updateRootNode(IConstants.TXT_DEFAULT);
		}
		
		for(String s : list)
		{
			TreeItem tItem = new TreeItem(ti, SWT.NONE);
			tItem.setText(Utils.siteNameMapping(s));
			// save the string data type into the tree node
			tItem.setData(s);
		}
		
		ti.setExpanded(true);
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		// TODO Auto-generated method stub
		
	}

}
