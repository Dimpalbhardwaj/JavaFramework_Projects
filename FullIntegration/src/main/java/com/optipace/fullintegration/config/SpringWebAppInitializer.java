package com.optipace.fullintegration.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer{

	public static final Logger LOGGER=Logger.getLogger(SpringWebAppInitializer.class);
	public SpringWebAppInitializer() {
		LOGGER.debug(this.getClass().getSimpleName()+"\t created...");
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOGGER.info("Innside on startup  method...");
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(SpringBean.class);
	        ctx.setServletContext(servletContext);
	        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	        LOGGER.info("outside on startup method....");
		
	}

}
