package org.bmsource.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class MessageProducerBean {

	@Resource(lookup = "java:/myJmsTest/MyConnectionFactory")
	ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/myJmsTest/MyQueue")
	Destination destination;

	public void produceMessage(String msg) throws JMSException {
		QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
		MessageProducer producer = null;
		QueueSession session = null;

		try {
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage(msg);
			producer.send(message);

		} finally {
			if (producer != null)
				producer.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		}
	}
}
