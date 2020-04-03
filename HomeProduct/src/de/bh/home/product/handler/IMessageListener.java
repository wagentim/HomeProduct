package de.bh.home.product.handler;

public interface IMessageListener
{
	void receivedAction(int type, Object content);
}
