// package org.bmsource.servlet;
//
// import java.io.IOException;
// import java.io.PrintWriter;
//
// import javax.servlet.Filter;
// import javax.servlet.FilterChain;
// import javax.servlet.FilterConfig;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.annotation.WebFilter;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// @WebFilter(value = "/*", asyncSupported = true)
// public class FilterResponseRewrite implements Filter {
//
// private static final Logger logger =
// LoggerFactory.getLogger(FilterResponseRewrite.class);
//
// @Override
// public void init(FilterConfig filterConfig) throws ServletException {
// logger.info("init");
// }
//
// @Override
// public void doFilter(ServletRequest request, ServletResponse response,
// FilterChain chain)
// throws IOException, ServletException {
//
// System.out.println("BEFORE filter");
// PrintWriter out = response.getWriter();
//
// chain.doFilter(request, response);
//
// String servletResponse = new String(response.toString());
// out.write(servletResponse + " filtered");
// }
//
// @Override
// public void destroy() {
// // TODO Auto-generated method stub
// }
//
// }
