package org.sample.controller;

import org.sample.domain.User;
import org.sample.domain.UserDetails;
import org.sample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView loginredir(@ModelAttribute("user") User user){
		System.out.println("##################Inside Loginred###############");
		ModelAndView model=new ModelAndView("login");
		return model;
	}

	@RequestMapping("/details")
	public ModelAndView login(@ModelAttribute("userDetails") UserDetails userDetails
			,@RequestParam("username") String name,@RequestParam("password") String pwd){
		boolean b= loginService.validateCredentials(name,pwd);
		System.out.println("##########user Not Av"+b);
		if(b==true){
		System.out.println("Value of User Status is"+b);
		ModelAndView model=new ModelAndView("details");
		model.addObject("uname",name);
		model.addObject("password",pwd);
		return model;
		}
		else{
			ModelAndView model=new ModelAndView("error");
			model.addObject("msg","PLEASE ENTER VALID CREDENTIALS");
			model.addObject("user",new User());
			return model;
		}
		}
	@RequestMapping("/detailsSaved")
	public ModelAndView stored(@RequestParam("email") String mail,@RequestParam("address") String address){
	
		return new ModelAndView("detailsSaved");
		}
}
