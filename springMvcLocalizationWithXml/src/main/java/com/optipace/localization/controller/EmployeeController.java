package com.optipace.localization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.optipace.localization.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	 @RequestMapping(value="/", method = RequestMethod.GET)
	    public String welcomePage()
	    {
	        return "employeesListDisplay";
	    }
	 @RequestMapping(value="/getAllEmployees", method = RequestMethod.GET)
	    public String welcome(Model model)
	    {
	        model.addAttribute("employees",service.getAllEmployees());
	        return "employeesListDisplay";
	    }
}
