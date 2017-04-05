package org.bmsource.servlet;

import java.util.Arrays;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class JettyRunner {
	private static Server server;

	public static void main(String... args) throws Exception {
		System.out.println("Using properties " + args);
		Arrays.asList(args).stream().forEach(param -> System.out.println(param));

		String webappDirLocation = args[0];
		server = new Server(Integer.parseInt(args[1]));

		WebAppContext context = new WebAppContext();
		context.setConfigurations(new Configuration[] { new AnnotationConfiguration(), new WebInfConfiguration(),
				new WebXmlConfiguration(), new MetaInfConfiguration(), new FragmentConfiguration(),
				new EnvConfiguration(), new PlusConfiguration(), new JettyWebXmlConfiguration() });

		context.setContextPath("/");
		context.setResourceBase(webappDirLocation);
		context.setParentLoaderPriority(true);
		server.setHandler(context);
		server.start();
		server.dump(System.out);
		server.join();
	}
}
