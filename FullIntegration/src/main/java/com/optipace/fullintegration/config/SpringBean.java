package com.optipace.fullintegration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.optipace.fullintegration.dto.SocietyRegistrationDTO;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource(value = { "classpath:/dbproperties/db.properties" })
@ComponentScan(basePackages = "com.optipace.fullintegration")
public class SpringBean {

	public static final Logger LOGGER = Logger.getLogger(SpringBean.class);

	public SpringBean() {
		LOGGER.debug(this.getClass().getSimpleName() + "\t created.....");
	}

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		LOGGER.debug("inside dataSource method");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("jdbc.driverClassName");
		dataSource.setUrl("jdbc.url");
		dataSource.setUsername("jdbc.username");
		dataSource.setPassword("jdbc.password");
		LOGGER.debug("outside data source method");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		LOGGER.debug("inside hibernate properties method");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.format_sql", "true");
		LOGGER.debug("utside hibernate properties mthod");
		return properties;
	}

	@Bean(name ="messageSource")
	public MessageSource messageSource() {
		LOGGER.debug("Insisde message source");
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/locale/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		LOGGER.debug("outside message source");
		return messageSource;
	}
	  @Bean
	   public ThemeSource themeSource() {
		  LOGGER.debug("Inside theme source");
	      ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
	      themeSource.setBasenamePrefix("theme/");
	      LOGGER.debug("outside theme source");
	      return themeSource;
	   }

	   @Bean
	   public ThemeResolver themeResolver() {
		   LOGGER.debug("inside theme resolver");
	      CookieThemeResolver resolver = new CookieThemeResolver();
	      resolver.setDefaultThemeName("pulse");
	      LOGGER.debug("outside theme resolver");
	      return resolver;
	   }


	
	 @Bean
	   public LocaleResolver localeResolver() {
		 LOGGER.debug("inside local resolver");
	      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	      LOGGER.debug("outside local resolver");
	      return localeResolver;
	   }
	 
	  public void addInterceptors(InterceptorRegistry registry) {
		  LOGGER.debug("innside addInceptors");
	      ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
	      themeChangeInterceptor.setParamName("theme");
	      registry.addInterceptor(themeChangeInterceptor);

	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      registry.addInterceptor(localeChangeInterceptor);
	      LOGGER.debug("outside addinceptors");
	   }


	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LOGGER.debug("inside session factory method");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(SocietyRegistrationDTO.class);
		sessionBuilder.addProperties(getHibernateProperties());
		LOGGER.debug("outside session factory method");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		LOGGER.debug("inside transaction manager method");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		LOGGER.debug("outside transaction manager method");
		return transactionManager;
	}
}
