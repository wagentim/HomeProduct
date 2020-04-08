package de.bh.home.product.ui.base;

import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.bh.home.product.actions.ActionLoadData;
import de.bh.home.product.core.IConstants;
import de.bh.home.product.handler.IMessageListener;
import de.bh.home.product.handler.MessageManager;
import de.bh.home.product.handler.UIHandler;
import de.bh.home.product.ui.tree.CategoryComposite;

public class MainScreen implements IMessageListener
{
	private final UIHandler controller;
	private final Color white;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	private SashForm main;
	private SashForm content;
	private ToolItem editToolItem;
	private ToolItem loadToolItem;
	private Label dateLabel;
	
	public MainScreen(final UIHandler controller)
	{
		this.controller = controller;
		white = controller.getColorProxy().getColorWhite();
		MessageManager.INSTANCE.addMessageListener(this);
		Display display = controller.getDisplay();
		
		Shell shell = new Shell(controller.getDisplay());
		shell.setText(IConstants.TXT_APP_TITLE);
		shell.setBackground(white);
//		shell.setImage(IMAGE_TITLE);
		
		initMainScreen(shell);
		initToolbar(shell);
		initMainComponents(shell);
		initKeyListener();
		
		Runnable timer = new Runnable()
		{
			public void run()
			{
//				dateLabel.setText(" " + sdf.format(new Date()) + " ");
//				controller.getDisplay().timerExec(1000, this);
			}
		};
		
		display.timerExec(1000, timer);
		
		shell.open();
		
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		
		display.dispose();
		
	}
	
	private void initKeyListener()
	{
//		this.getShell().getDisplay().addFilter(SWT.KeyDown, new Listener()
//		{
//			
//			@Override
//			public void handleEvent(Event event)
//			{
//				if( ((event.stateMask & SWT.CTRL) == SWT.CTRL) && ((event.keyCode == 'f') || (event.keyCode == 'F')) )
//				{
//					ProtectorActionManager.INSTANCE().sendAction(IProtectorActionType.ACTION_FOCUS_SEARCH, null);
//				}
//				else if( ((event.stateMask & SWT.CTRL) == SWT.CTRL) && ((event.keyCode == 'r') || (event.keyCode == 'R')) )
//				{
//					ProtectorActionManager.INSTANCE().sendAction(IProtectorActionType.ACTION_FOCUS_TREE, null);
//				}
//				else if( ((event.stateMask & SWT.CTRL) == SWT.CTRL) && ((event.keyCode == 't') || (event.keyCode == 'T')) )
//				{
//					ProtectorActionManager.INSTANCE().sendAction(IProtectorActionType.ACTION_FOCUS_TABLE, null);
//				}
//			}
//		});
	}

	private void initMainComponents(Composite shell)
	{
		main = new SashForm(shell, SWT.VERTICAL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		main.setLayoutData(gd);

		content = new SashForm(main, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		content.setLayoutData(gd);
		
		Composite location = new Composite(main, SWT.NONE);
		location.setVisible(false);

		new CategoryComposite(content, SWT.BORDER, controller);
		CustomTableComposite tableComposite = new CustomTableComposite(content, SWT.NONE, controller);
		tableComposite.updateTableTitle(IConstants.TXT_TABLE_HEADER);
		
		
		content.setWeights(new int[] {1, 3});
		main.setWeights(new int[]{ 1, 0 });
		
	}

	private void initToolbar(Composite shell)
	{
		GridLayout layout = new GridLayout(1, false);
		layout.marginTop = layout.marginLeft = layout.marginRight = layout.marginBottom = 0;
		shell.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		shell.setLayoutData(gd);
		
		ToolBar bar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		bar.setBackground(controller.getColorProxy().getColorWhite());
		loadToolItem = new ToolItem(bar, SWT.PUSH);
		loadToolItem.setImage(controller.getImageProxy().getImage(IImageConstants.IMAGE_LOAD_OUTLINE));
		loadToolItem.setHotImage(controller.getImageProxy().getImage(IImageConstants.IMAGE_LOAD_COLOR));
		loadToolItem.addSelectionListener(new ActionLoadData(controller));
		
		new ToolItem(bar, SWT.SEPARATOR);
	}
	
	private void initMainScreen(Composite shell)
	{
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
		Rectangle area = primary.getClientArea();
//		shell.pack();
		shell.setBounds((Math.abs(area.width - IConstants.MAIN_SCREEN_WIDTH)) / 2,
				Math.abs((area.height - IConstants.MAIN_SCREEN_HEIGHT)) / 2, IConstants.MAIN_SCREEN_WIDTH,
				IConstants.MAIN_SCREEN_HEIGHT);

		GridLayout layout = new GridLayout(1, false);
		layout.marginTop = 10;
		layout.marginLeft = 10;
		layout.marginRight = 10;
		layout.marginBottom = 10;
		shell.setLayout(layout);
	}

	@Override
	public void receivedAction(int type, Object content)
	{
	}
}
