package com.techm.learning.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techm.learning.model.LPUser;
import com.techm.learning.service.CustomUserDetailsService;
import com.techm.learning.util.UserRoleType;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */
@Controller
public class LoginController {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	BCryptPasswordEncoder encoder;

	@RequestMapping(value = { "/", "/home**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null && null != error.trim()) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login2");

		return model;

	}
	
	@RequestMapping(value = "/redirectLogin")
	public ModelAndView redirectLogin() {
		
		ModelAndView mv = new ModelAndView();
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority(UserRoleType.MANAGER.toString()))){
			mv.setViewName("feedback");
		}else if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority(UserRoleType.ADMIN.toString()))){
			mv.setViewName("hello");
		}
		return mv;

	}
	
	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
	
	@RequestMapping(value = "/setup", method = RequestMethod.GET)
	public String getFeedbackView(Model model) {
		
		
		Session ss=sessionFactory.openSession();
		try{
			
		BCryptPasswordEncoder   encoder = new BCryptPasswordEncoder();
		
		LPUser myUser=new LPUser();
		myUser.setUsername("admin");
		myUser.setPassword(encoder.encode("1234"));
		
		
		}catch(Exception e){
			
		}finally{
			
		}
		return "index";
	}
	
	

}