package org.bmsource.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/myJmsTest/MyQueue") })
public class MessageDrivenBean implements MessageListener {
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;

			try {
				System.out.println(String.format("A message was found! ^__^ It is: '%s'", textMessage.getText()));
			} catch (Exception ex) {
				ex.printStackTrace(System.err);
			}
		}
	}
}