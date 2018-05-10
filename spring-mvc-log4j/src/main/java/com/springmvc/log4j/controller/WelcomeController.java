package com.springmvc.log4j.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	public static final Logger LOGGER=Logger.getLogger(WelcomeController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getWelcome()
	{
		//logs debug message
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug("getWelcome is executed!");
				}
				//logs exception
				LOGGER.error("This is Error message", new Exception("Testing"));
				
				ModelAndView model = new ModelAndView("Welcome");
				model.addObject("msg", "Hello Spring MVC + Log4j");
				return model;

	}

}
