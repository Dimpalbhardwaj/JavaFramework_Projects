package com.optipace.fullintegration.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.optipace.fullintegration.dto.SocietyRegistrationDTO;
import com.optipace.fullintegration.service.SocietyRegistrationService;

@Controller
@RequestMapping("/")
public class SocietyController {
	
	public static final Logger LOGGER = Logger.getLogger(SocietyController.class);

	@Autowired
	private SocietyRegistrationService service;
	
	public SocietyController() {
		LOGGER.debug(this.getClass().getSimpleName() + "\t created...");
	}

	 @RequestMapping(value="/", method=RequestMethod.GET)
	   public String index(Model model) {
		 model.addAttribute("society", new SocietyRegistrationDTO());
	      return "index";
	   }
	 
	 @RequestMapping(value="/save.do", method=RequestMethod.POST)
	 public ModelAndView formPost(SocietyRegistrationDTO dto)
	 {
		 LOGGER.debug("Inside save method controller");
		 service.saveForm(dto);
		return null;
		 
	 }


}
