package de.bh.home.product.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.bh.home.product.handler.UIHandler;

public class CustomTableComposite extends AbstractComposite
{
	private final UIHandler controller;
	private final Color white;
	private Table table;

	public CustomTableComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style, controller);
		white = controller.getColorProxy().getColorWhite();
		this.controller = controller;
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
		
		new SearchComposite(this, SWT.BORDER, controller);
		
		table = new Table(this, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		gd = new GridData(GridData.FILL_BOTH);
		table.setLayoutData(gd);	
	}
	
	public void updateTableTitle(String[] titles)
	{
		if(titles == null || titles.length <= 0)
		{
			return;
		}
		
		for (int i = 0; i < titles.length; i++)
		{
			TableColumn column = null;
			
			try
			{
				column = table.getColumn(i);
			}
			catch(Exception e)
			{
				column = null;
			}
			
			if(column == null)
			{		
				column = new TableColumn(table, SWT.LEFT);
			}
			column.setText(titles[i]);
			column.setResizable(true);
			if( i == 0 )
			{
				column.setWidth(400);
			}
			else
			{
				column.setWidth(150);	
			}
		}
	}
	
	protected void clearTableItems()
	{
		if (null == table)
		{
			return;
		}

		TableItem[] items = table.getItems();

		if (items.length <= 0)
		{
			return;
		}

		for (int i = items.length - 1; i >= 0; i--)
		{
			TableItem item = items[i];
			table.remove(i);
			item.dispose();
		}
	}

	@Override
	public void receivedAction(int type, Object content)
	{

	}

}
