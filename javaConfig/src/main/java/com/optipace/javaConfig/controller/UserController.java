package com.optipace.javaConfig.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.optipace.javaConfig.dao.UserDAO;
import com.optipace.javaConfig.dto.UserDTO;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDao;

	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<UserDTO> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("userList");
		model.addObject("userList", listUsers);
		return model;
	}

	@RequestMapping(value = "/userForm")
	public ModelAndView newUser() {
		System.out.println("for userform");
		ModelAndView model = new ModelAndView("userForm");
		model.addObject("user", new UserDTO());
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		System.out.println("for edit userform");
		int userId = Integer.parseInt(request.getParameter("id"));
		UserDTO user = userDao.get(userId);
		ModelAndView model = new ModelAndView("userForm");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		System.out.println("for delete userform");
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.delete(userId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute UserDTO user) {
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}

}
