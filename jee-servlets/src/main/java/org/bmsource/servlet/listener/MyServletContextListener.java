package org.bmsource.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.bmsource.servlet.async.AsyncServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(AsyncServlet.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("AAAAA {}", sce);

		ServletContext sc = sce.getServletContext();
		String path = sc.getInitParameter("path");
		String mode = sc.getInitParameter("mode");
		logger.info("path {}", path);
		logger.info("mode {}", mode);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println(event);
	}

}
