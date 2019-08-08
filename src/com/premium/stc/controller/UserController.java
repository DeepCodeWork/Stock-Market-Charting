package com.premium.stc.controller;

import javax.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.premium.stc.model.User;
import com.premium.stc.service.UserServiceInterface;

@RestController
public class UserController {
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@Autowired
	UserServiceInterface userServiceInterface;

	//@RequestMapping("/")
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("registerUser")
	public ModelAndView registerUser(@ModelAttribute("message") String message) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userData", new User());
		mv.addObject("message", message);
		mv.setViewName("userRegistration");
		return mv;
	}

	@PostMapping("registerUser")
	public ModelAndView addOrUpdateUser(@Valid @ModelAttribute("userData") User userData,WebRequest request, BindingResult result,RedirectAttributes attribute) {
		//ModelAndView mv = new ModelAndView();
		try {
			if(!result.hasErrors()) {
				//eventPublisher.publishEvent();
				int check = userServiceInterface.addOrUpdateUser(userData,1);
				if(check>0) {
					return new ModelAndView("redirect:/userLogin","message","Login in with your id and password");
				}else{
					return new ModelAndView("redirect:/registerUser","message","Enter details correctly"); 
				}
			}
		} catch (Exception e) {
			System.out.println("user details already exist");
		}
		return new ModelAndView("redirect:/registerUser","message", "user details already exist");

	}

	@GetMapping("userLogin")
	public ModelAndView loginUser(@ModelAttribute("message")String message) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", message);
		mv.setViewName("userLogin");
		return mv;
	}

	@PostMapping("userAuthenticate")
	public String authenticateUser(@RequestParam("username") String username,
			@RequestParam("userPassword") String userPassword){
		if(userServiceInterface.getUser(username, userPassword)!=null)
			return "success";
		else {
			System.out.println("Not found");
			return "404";
		}
	}
	
	@GetMapping("usersList")
	public ModelAndView getUsersList(){
		List<User> listOfUsers = userServiceInterface.usersList();
		if(listOfUsers.size()!=0&&listOfUsers!=null) {
			return new ModelAndView("usersListPage","listOfUsers", listOfUsers);
		}else {
			return new ModelAndView("404","message", "No user found");
		}
	}
	
	@GetMapping("updateUser/{id}")
	public ModelAndView updateUserPage(@PathVariable("id") String userId) {
		ModelAndView mv = new ModelAndView();
		try {
			int x = Integer.parseInt(userId);
			mv.addObject("userData", userServiceInterface.getUserByIdOrUsername(x, ""));
		} catch (NumberFormatException e) {
			mv.addObject("userData", userServiceInterface.getUserByIdOrUsername(0, userId));
		}
		
		mv.setViewName("UpdateUserPage");
		return mv;
	}
	
	@PatchMapping("userUpdated")
	public ModelAndView updateUser(@ModelAttribute("userData") User userData) {
		userServiceInterface.addOrUpdateUser(userData, 2);
		return new ModelAndView("success","message","User updates successfully");
		
	}
	
	@RequestMapping("deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") String userId) {
		boolean flag=false;
		try {
			int x = Integer.parseInt(userId);
			flag = userServiceInterface.deleteUserByIdOrUsername(x, "");
		} catch (NumberFormatException e) {
			flag = userServiceInterface.deleteUserByIdOrUsername(0, userId);
		}
		
		if(flag) {
			return new ModelAndView("success","message","User successfully deleted");
		}else {
			return new ModelAndView("404","message","No user found with that id");
		}
	}
	
	









}
