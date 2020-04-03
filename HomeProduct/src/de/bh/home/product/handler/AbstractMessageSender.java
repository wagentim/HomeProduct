package de.bh.home.product.handler;

public abstract class AbstractMessageSender implements IMessageListener
{
	public AbstractMessageSender()
	{
		MessageManager.INSTANCE.addMessageListener(this);
	}
}
