package com.optipace.fileUploading.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FileWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	public FileWebInitializer() {
	System.out.println(this.getClass().getSimpleName()+"\t created...");
	}
	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { FileConfiguration.class };
	    }
	   
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	   
	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }
}
