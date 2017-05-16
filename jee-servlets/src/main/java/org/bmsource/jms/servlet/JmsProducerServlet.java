package org.bmsource.jms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bmsource.jms.MessageProducerBean;

@WebServlet(urlPatterns = "/send")
public class JmsProducerServlet extends HttpServlet {

	@EJB
	MessageProducerBean messageProducerBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			messageProducerBean.produceMessage(req.getParameter("message"));
			writer.println("Message sent! ^__^");
		} catch (Exception ex) {
			ex.printStackTrace(writer);
		}
	}
}