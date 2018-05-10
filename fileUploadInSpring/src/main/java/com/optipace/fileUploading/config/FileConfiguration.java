package com.optipace.fileUploading.config;

import java.io.IOException;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.optipace.fileUploading")
public class FileConfiguration extends WebMvcConfigurerAdapter {
	public FileConfiguration() {
		System.out.println(this.getClass().getSimpleName()+"\t created.......");
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {

		System.out.println("Inside commonmultipart resolver");
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);// 5MB
		// You may also set other available properties.
		System.out.println("outside commonmultipart resolver");
		return resolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		System.out.println("Inside internal view resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
		System.out.println("outside internal view resolver");
	}

	@Bean
	public MessageSource messageSource() {
		System.out.println("inside message source");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		System.out.println("Outside message source");
		return messageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	
}
