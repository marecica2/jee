package org.bmsource.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = -910661220169235282L;

	private static final Logger logger = LoggerFactory.getLogger(SessionServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(req.getDispatcherType() + "");
		resp.getOutputStream().println("<html>");
		resp.getOutputStream().println("<body>");
		resp.getOutputStream().println("<p>" + req.getSession().getAttribute("post") + "</p>");
		resp.getOutputStream().println("<form action='' method='POST'>");
		resp.getOutputStream().println("<input type='submit' value='Submit'>");
		resp.getOutputStream().println("</form>");
		resp.getOutputStream().println("</body>");
		resp.getOutputStream().println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("inside post");
		resp.sendRedirect(req.getServletPath());
		HttpSession session = req.getSession(true);
		session.setAttribute("post", new Date());
	}

}
