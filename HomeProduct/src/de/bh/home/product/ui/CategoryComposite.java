package de.bh.home.product.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.handler.UIHandler;

public class CategoryComposite extends AbstractComposite
{
	private final UIHandler controller;
	private final Color white;
	private TabFolder tf;
	private CustomTreeComposite treeSite;
	private CustomTreeComposite treeCategory;

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
		treeSite = new CustomTreeComposite(tf, SWT.NONE, controller);
		ti1.setControl(treeSite);
		ti1.setText(IConstants.TXT_WEBSITE);
		treeSite.updateRootNode(IConstants.TXT_WEBSITE);
		treeSite.updateChildrenNodes(controller.getSetting().getWebSites());
		
		TabItem ti2 = new TabItem(tf, SWT.NONE);
		treeCategory = new CustomTreeComposite(tf, SWT.NONE, controller);
		ti2.setControl(treeCategory);
		ti2.setText(IConstants.TXT_CATEGORY);
		
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		
	}

}
