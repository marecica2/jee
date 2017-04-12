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
		req.getSession().invalidate();
		logger.info(req.getDispatcherType() + "");
		resp.getOutputStream().println("<html>");
		resp.getOutputStream().println("<body>");
		resp.getOutputStream().println("<p>" + req.getSession().getAttribute("post") + "</p>");
		resp.getOutputStream().println("<p>" + req.getSession().getId() + "</p>");
		resp.getOutputStream().println("<p>" + req.getSession().getLastAccessedTime() + "</p>");
		resp.getOutputStream().println("<p>" + req.getSession().getMaxInactiveInterval() + "</p>");
		resp.getOutputStream().println("<p>" + req.getSession().getCreationTime() + "</p>");
		resp.getOutputStream().println("<form action='' method='POST'>");
		resp.getOutputStream().println("<input type='submit' value='Submit'>");
		resp.getOutputStream().println("<input type='text' name='name'>");
		resp.getOutputStream().println("<a href='asyncservlet'>To another page</a>");
		resp.getOutputStream().println("</form>");
		resp.getOutputStream().println("</body>");
		resp.getOutputStream().println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		logger.info(req.getRequestURI() + req.getSession().getId());
		session.setAttribute("post", new Date());
		resp.sendRedirect(req.getContextPath() + req.getServletPath());
	}

}
