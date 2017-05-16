package org.bmsource.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ListenerForServletContext implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ServletAsync.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		logger.info("Inside servlet context listener");
		logger.info("Context path {}", sc.getContextPath());
		logger.info("Context path {}", sc.getContextPath());
		String path = sc.getInitParameter("path");
		String mode = sc.getInitParameter("mode");
		logger.info("Init parameter path {}", path);
		logger.info("Init parameter mode {}", mode);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}
