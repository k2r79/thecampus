package com.intuitiv.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.service.UserService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("email") String email, @ModelAttribute("password") String password) throws CampusException {
		ModelAndView model = new ModelAndView("Home");
		if(userService.emailExists(email)){
			if(userService.passwordMatchWithEmail(email, password)){
				model.setViewName("User");
				model.addObject("userSession", userService.getUserByMail(email));
			} else {
				model.addObject("loginError", "Le mot de passe est érroné");
			}
		} else {
			model.addObject("loginError", "L'email saisi n'existe pas.");
		}
		return model;
	}

}
