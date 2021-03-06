package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.bean.User;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	User emptyUser;
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("Some info")
	public String addInfoToRequestScope(){
		System.out.println("Adding info to the modelMap");
		return "This is added information";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap){
		
		System.out.println(modelMap.get("Some info"));
		System.out.println("GET REQUEST");
		modelMap.addAttribute("user", emptyUser);
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(@Valid User user, 
								BindingResult bindingResult, 
								ModelMap modelMap, 
								HttpSession session){
		
		System.out.println("POST METHOD");
		
		/*
		 * @Valid
		 * -Apply a validation check on user object.
		 * 	-Its at this point, it will validate against our validator annotations that 
		 * 		we used in our user bean.
		 * -BindingResult, this object houses error messages, should any of the @Valid
		 * 	checks come back as a failure.
		 * -ModelMap: this object represents the data being passed around the backend, and will 
		 * 	ultimately be passed back to the client at the end of the lifecycle displayed through
		 * 	a view.
		 * -HttpSession: Obvious, this is the session object.
		 */
		if(bindingResult.hasErrors()){
			return "login";
		}
		
		User authUser = userService.auth(user);
		
		if(authUser != null){
			System.out.println(user.getUsername());
			modelMap.addAttribute("user", user);   //request scope
			session.setAttribute("alsoUser", user);//session scope
			return "home";
		}
		else{
			modelMap.addAttribute("errorMessage", "username/password incorrect");
			return "login";
		}
	}

}
