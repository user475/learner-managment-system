package com.jpmc.learner.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpmc.learner.models.User;
import com.jpmc.learner.service.UserService;

@Controller
public class UserController {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private UserService userService;

	
	/**
	 * @param model
	 * @return Register Page
	 */
	@GetMapping(value = "/register")
	public ModelAndView newUser(ModelAndView model) {
		
		User user = applicationContext.getBean(User.class);
		model.addObject("user", user);
		model.setViewName("registration");
		return model;
	}

	
	/**
	 * take the values and validate user exists or not and take further actions
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/register")
	public String registeruser(@ModelAttribute User user, Model model) {
		User exists = checkuserExistsOrNot(user.getUsername());

		if (exists == null) {
			String name = user.getFullName().replace(" ", "");
			user.setFullName(name);
			userService.registerUser(user);
			// return "/user-login-page";
			return "redirect:/login";
		} else {
			model.addAttribute("error", "user name already Exists ");
			return "redirect:/login?error=user name already Exists";
		}

	}

	/** 
	 * Accepts the userName and return the user object of that userName
	 * @param userName
	 * @return  user object
	 */
	public User checkuserExistsOrNot(String userName) {
	
		return userService.getUserByUserName(userName);
	}


	/**  
	 * show the register page
	 * @param model
	 * @param error
	 * @return  
	 */
	@GetMapping(value = { "/login" })
	public ModelAndView userLogin(ModelAndView model, @RequestParam(value = "error", required = false) String error) {
		User user = applicationContext.getBean(User.class);

		model.addObject("user", user);
		model.setViewName("login");
		model.addObject("error", error);
		return model;
	}

	/**
	 * Accepts the values and validate userName and Password and redirect to
	 * appropriate pages
	 * @param user user contain data 
	 * @param model
	 * @param response
	 * @return
	 */
	@PostMapping(value = "/login")
	public String loginuser(@ModelAttribute User user, Model model, HttpServletResponse response) {

		User dbUser = userService.getUserByUserName(user.getUsername());
		if (dbUser == null) {
			model.addAttribute("error", "Please Register");
			return "/registration.html";
		} else if (dbUser.getPassword().equals(user.getPassword())) {
			String type = dbUser.getUserType();
			response.addCookie(new Cookie("userType", dbUser.getUserType()));
			response.addCookie(new Cookie("userId", "" + dbUser.getUserId()));
			response.addCookie(new Cookie("userName", dbUser.getFullName().trim()));
			
			if (type.equals("Teacher"))
				return "redirect:/teacher/courses";
			return "redirect:/student/home";
		}
		model.addAttribute("error", "Please Enter correct password");

		return "/login.html";
	}

	/**
	 * @return
	 */
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
