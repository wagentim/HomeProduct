package de.bh.home.product.ui.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.entity.AbstractTreeElement;
import de.bh.home.product.handler.UIHandler;

public abstract class AbstractTreeComposite extends AbstractComposite
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractTreeElement.class);

	protected final UIHandler controller;
	protected final Color white;
	
	protected Tree tree;

	public AbstractTreeComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style, controller);
		this.controller = controller;
		white = controller.getColorProxy().getColorWhite();
		initComposite();
	}

	protected void initComposite()
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
		tree.addSelectionListener(getSelectionListener());
	}
	
	protected abstract SelectionListener getSelectionListener();

	public TreeItem updateRootNode(AbstractTreeElement element)
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
		
		ti.setText(element.getName());
		ti.setData(element);
		
		return ti;
	}
	
	public void addChildrenNodes(TreeItem root, AbstractTreeElement[] children)
	{
		if( children == null || children.length == 0 )
		{
			return;
		}
		
		if( root == null )
		{
			root = new TreeItem(tree, SWT.NONE);
			root.setText(IConstants.TXT_DEFAULT);
		}
		
		for(AbstractTreeElement s : children)
		{
			TreeItem tItem = new TreeItem(root, SWT.NONE);
			tItem.setText(getDisplayNodeName(s));
			// save the string data type into the tree node
			tItem.setData(s);
		}
		
		root.setExpanded(true);
	}
	
	protected abstract String getDisplayNodeName(final AbstractTreeElement element);
	
	public List<AbstractTreeElement> getSelectedElement()
	{
		TreeItem[] selections = tree.getSelection();
		
		List<AbstractTreeElement> result = Collections.emptyList();
		
		if( selections != null && selections.length > 0 )
		{
			result = new ArrayList<AbstractTreeElement>();
			for(TreeItem ti : selections)
			{
				AbstractTreeElement e = (AbstractTreeElement) ti.getData();
				
				if( e != null )
				{
					result.add(e);
				}
				else
				{
					logger.error("The Saved Tree Original Data is NULL with tree node: {}", ti.getText());
				}
			}
		}
		
		return result;
	}

}
