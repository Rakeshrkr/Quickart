package com.quickart.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quickart.dao.*;
import com.quickart.model.*;


@Controller
public class RegisterController {

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		ModelAndView modelandview = new ModelAndView("Register");
		return modelandview;
	}

	@RequestMapping(value = "/RegistrationSuccess", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@Valid @ModelAttribute() User user, BindingResult result) {
		/*
		 * String fullName = details.get("fullName"); String email =
		 * details.get("email"); String birthDate = details.get("birthDate");
		 * String country = details.get("country"); String gender =
		 * details.get("gender"); String password = details.get("password") ;
		 * User user = new User(); user.setFullName(fullName);
		 * user.setEmail(email); user.setBirthDate(birthDate);
		 * user.setCountry(country); user.setGender(gender);
		 * user.setPassword(password);
		 */
		if (result.hasErrors()) {
			ModelAndView modelandview = new ModelAndView("Register");
			return modelandview;
			/*
			 * public String showRegister(){ return "Register" ; }
			 */
		} else {
			ModelAndView modelandview = new ModelAndView("RegistrationSuccess");
			/*
			 * modelandview.addObject("details","fullName = " + fullName +
			 * ", Email = " + email + " , Date of Birth = " + birthDate +
			 * " , Country = " + country + ", Gender = " + gender) ;
			 */
			/* modelandview.addObject("user", user); */
			return modelandview;
		}
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(new String[] {"password"});
		
	}
}
