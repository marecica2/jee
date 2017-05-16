package org.bmsource.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bmsource.ejb.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

	private static final long serialVersionUID = 3572170589473494863L;

	@EJB
	BeanProvider beanProvider;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getOutputStream().println("<html>");
		resp.getOutputStream().println("<body>");
		resp.getOutputStream().println("Hello");
		resp.getOutputStream().println("<a href='./asyncservlet'>Async</a>");
		resp.getOutputStream().println("</body>");
		resp.getOutputStream().println("</html>");
	}

}
