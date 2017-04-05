package org.bmsource.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/asyncservlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 3572170589473494863L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("Heere");

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
			}
		});

		System.err.println("Finished");
	}

}
