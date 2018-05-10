package com.optipace.javaConfig.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer{

	public SpringWebAppInitializer()
	{
		System.out.println(this.getClass().getSimpleName()+"\t created...");
	}
	
	public void onStartup(ServletContext container) throws ServletException {
		System.out.println("inside onstartup");
		  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(SpringBean.class);
	        ctx.setServletContext(container);
	        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	        System.out.println("outside startup");
	}

	
}