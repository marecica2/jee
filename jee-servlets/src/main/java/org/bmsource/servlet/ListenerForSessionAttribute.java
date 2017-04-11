package org.bmsource.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ListenerForSessionAttribute implements HttpSessionAttributeListener {

	private static final Logger logger = LoggerFactory.getLogger(ListenerForSessionAttribute.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.info("Session Attribute added {}:{}", event.getName(), event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.info("Session Attribute removed {}:{}", event.getName(), event.getValue());

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.info("Session Attribute replaced {}:{}", event.getName(), event.getValue());

	}

}
