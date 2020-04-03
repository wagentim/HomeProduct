package de.bh.home.product.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.handler.UIHandler;


public class SearchComposite extends AbstractComposite
{
	
	protected UIHandler controller;
	private Text searchText;
	private final Color white;
	private Label cancelImage;
	
	public SearchComposite(Composite parent, int style, UIHandler controller)
	{
		super(parent, style, controller);
		
		
		white = parent.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		
		GridLayout layout = new GridLayout(3, false);
		layout.marginTop = layout.marginBottom = layout.marginLeft = layout.marginRight = 0; 
		layout.marginHeight = layout.marginWidth = 3;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.minimumHeight = 30;
		this.setLayout(layout);
		this.setLayoutData(gd);
		this.setBackground(white);
		
		Label label = new Label(this, SWT.NONE);
		label.setImage(controller.getImageProxy().getImage(IImageConstants.IMAGE_SEARCH));
		gd = new GridData();
		label.setLayoutData(gd);
		label.setBackground(white);
		
		searchText = new Text(this, SWT.NONE);
		gd = new GridData(GridData.FILL_BOTH);
		gd.verticalSpan = gd.horizontalSpan = 0;
		searchText.setLayoutData(gd);
		searchText.setMessage("Search");
		
		searchText.addModifyListener(new ModifyListener()
		{
			
			@Override
			public void modifyText(ModifyEvent event)
			{
				String text = searchText.getText();
//				controller.createSearchRecords(text);
				if(!text.isEmpty())
				{
					cancelImage.setVisible(true);
				}
				else
				{
					cancelImage.setVisible(false);
				}
				
//				ProtectorActionManager.actionManager.sendAction(IProtectorActionType.ACTION_SEARCH_RECORD_UPDATED, text);
			}
		});
		
		cancelImage = new Label(this, SWT.NONE);
		cancelImage.setImage(controller.getImageProxy().getImage(IImageConstants.IMAGE_CANCEL));
		gd = new GridData();
		cancelImage.setLayoutData(gd);
		cancelImage.setBackground(white);
		cancelImage.setVisible(false);
		cancelImage.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseUp(MouseEvent arg0)
			{
				searchText.setText(IConstants.EMPTY_STRING);
				cancelImage.setVisible(false);
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}

		});
		
		this.controller = controller;
	}
	
	@Override
	public void receivedAction(int type, Object content)
	{
		/*
		if( type == IProtectorActionType.ACTION_DATA_LOADED)
		{
			searchText.setText(IGlobalConstants.EMPTY_STRING);
		}
		else if( type == IProtectorActionType.ACTION_FOCUS_SEARCH )
		{
			searchText.setFocus();
		}
		*/
	}

}
