package com.optipace.internationalization.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
@Configuration
@EnableWebMvc
@ComponentScan("com.optipace.internationalization.controller")
public class MvcWebConfig implements WebMvcConfigurer{
	
	public MvcWebConfig()
	{
		System.out.println(this.getClass().getSimpleName()+"\t craeted....");
	}
	public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/views/", ".jsp");
	   }


	   @Bean("messageSource")
	   public MessageSource messageSource() {
		   System.out.println("Insisde message source");
	      ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
	      messageSource.setBasename("classpath:locale/messages");
	      messageSource.setDefaultEncoding("UTF-8");
	      messageSource.setUseCodeAsDefaultMessage(true);
	      System.out.println("outside message source");
	      return messageSource;
	   }

	   @Bean
	   public ThemeSource themeSource() {
		   System.out.println("Inside theme source");
	      ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
	      themeSource.setBasenamePrefix("theme/");
	      System.out.println("outside theme source");
	      return themeSource;
	   }

	   @Bean
	   public ThemeResolver themeResolver() {
		   System.out.println("inside theme resolver");
	      CookieThemeResolver resolver = new CookieThemeResolver();
	      resolver.setDefaultThemeName("pulse");
	      System.out.println("outside theme resolver");
	      return resolver;
	   }

	   @Bean
	   public LocaleResolver localeResolver() {
		   System.out.println("inside local resolver");
	      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	      System.out.println("outside local resolver");
	      return localeResolver;
	   }

	   public void addInterceptors(InterceptorRegistry registry) {
		   System.out.println("innside addInceptors");
	      ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
	      themeChangeInterceptor.setParamName("theme");
	      registry.addInterceptor(themeChangeInterceptor);

	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      registry.addInterceptor(localeChangeInterceptor);
	      System.out.println("outside addinceptors");
	   }

}
