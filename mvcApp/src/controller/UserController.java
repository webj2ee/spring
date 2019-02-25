package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import entity.User;

@Controller
public class UserController {

	@Autowired
	UserDao dao;
	@Autowired
	HttpSession session;
	
	//High level implementation
	//Method to process login request
	@RequestMapping(value="/login.spring",
			method=RequestMethod.POST)
	public String login(
		@ModelAttribute	User user)
	throws Exception
	{
		
		if(dao.find(user))
		{
			//user is stored in the session
			session.setAttribute("user", user);
			return "home";
		}
		else 
			return "relogin";
	}
	//method to process logout request
	@RequestMapping(value="/logout.spring")
	public String logout()
	{
		session.invalidate();
		return "loggedOut";
	}
	
}
