package org.bmsource.servlet.async;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bmsource.ejb.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/asyncservlet", asyncSupported = true, loadOnStartup = 1)
public class AsyncServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(AsyncServlet.class);

	private static final long serialVersionUID = 3572170589473494863L;

	@EJB
	BeanProvider beanProvider;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("{} started", this.getClass().getName());

		beanProvider.getBeans();

		AsyncContext acontext = req.startAsync();
		acontext.start(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				String param = acontext.getRequest().getParameter("param");
				// String result = resource.process(param);
				HttpServletResponse response = (HttpServletResponse) acontext.getResponse();
				try {
					response.getOutputStream().print("ok" + param);
				} catch (IOException e) {
					e.printStackTrace();
				}
				acontext.complete();
				logger.info("{} finished", this.getClass().getName());
			}
		});

	}

}
