package de.bh.home.product.ui.tree;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TreeItem;

import de.bh.home.product.actions.IActionConstants;
import de.bh.home.product.core.IConstants;
import de.bh.home.product.entity.AbstractTreeElement;
import de.bh.home.product.entity.WebSiteElement;
import de.bh.home.product.handler.IEvents;
import de.bh.home.product.handler.MessageManager;
import de.bh.home.product.handler.UIHandler;
import de.bh.home.product.ui.base.AbstractComposite;
import de.bh.home.product.ui.base.AbstractTreeComposite;

public class CategoryComposite extends AbstractComposite
{
	private final UIHandler controller;
	private final Color white;
	private TabFolder tf;
	private WebSiteTreeComposite treeSite;
	private AbstractTreeComposite treeCategory;
	
	public CategoryComposite(Composite parent, int style, UIHandler controller)
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
		
		tf = new TabFolder(this, SWT.NONE);
		gd = new GridData(GridData.FILL_BOTH);
		tf.setLayoutData(gd);
		
		tf.setBackground(white);
		TabItem ti1 = new TabItem(tf, SWT.NONE);
		treeSite = new WebSiteTreeComposite(tf, SWT.NONE, controller);
		ti1.setControl(treeSite);
		ti1.setText(IConstants.TXT_WEBSITE);
		TreeItem root = treeSite.updateRootNode(new WebSiteElement(IConstants.TXT_WEBSITE));
		treeSite.addChildrenNodes(root, controller.getWebSites());
		
		TabItem ti2 = new TabItem(tf, SWT.NONE);
		treeCategory = new CategoryTreeComposite(tf, SWT.NONE, controller);
		ti2.setControl(treeCategory);
		ti2.setText(IConstants.TXT_CATEGORY);
		
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		if( type == IActionConstants.ACTION_LOAD )
		{
			int index = tf.getSelectionIndex();
			switch(index)
			{
				case 0:
					List<AbstractTreeElement> ele = treeSite.getSelectedElement();
					if( ele != null && !ele.isEmpty() )
					{
						getAllProducts(ele.get(0));
					}
					break;
			}
		}
	}
	
	private void getAllProducts(AbstractTreeElement selectedElement)
	{
		String tableName = selectedElement.getName();
		controller.loadProductFromDB(tableName);
		MessageManager.INSTANCE.sendMessage(IEvents.EVENT_LOAD_DB_DATA, tableName);
	}
}
