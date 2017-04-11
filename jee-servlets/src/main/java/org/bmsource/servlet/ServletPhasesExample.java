package org.bmsource.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/servlet", loadOnStartup = 1)
public class ServletPhasesExample extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(ServletPhasesExample.class);

	private static final long serialVersionUID = -473835777237474478L;

	@Override
	public void destroy() {
		super.destroy();
		logger.info("ServletPhasesExample destroyed");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		logger.info("ServletPhasesExample initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("ServletPhasesExample doGet call");
		resp.getWriter().println("ServletPhasesExample initialized");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("ServletPhasesExample service call");
		super.service(req, resp);
	}

}
