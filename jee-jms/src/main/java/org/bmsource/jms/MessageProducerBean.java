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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class MessageProducerBean {

	private static final Logger logger = LoggerFactory.getLogger(MessageProducerBean.class);

	@Resource(lookup = "java:/myJmsTest/MyConnectionFactory")
	ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/myJmsTest/MyQueue")
	Destination destination;

	public void produceMessage(String msg) {

		try (QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
				QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageProducer producer = session.createProducer(destination);) {

			TextMessage message = session.createTextMessage(msg);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
}
