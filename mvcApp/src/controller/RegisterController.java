package controller;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import entity.User;
import validator.MailValidator;

@Controller
public class RegisterController {

	//dependencies
	@Autowired
	UserDao dao;
	@Autowired
	MailValidator mailValidator;
	/*
	//low level implementation
	//Method to process registration request
	@RequestMapping(value="/register.spring",
			method=RequestMethod.POST)
	public String register(ServletRequest request)
	throws Exception
	{
		User user=new User();
		user.setName(request.getParameter("name"));
		user.setMailId(request.getParameter("mailId"));
		user.setPassword(request.getParameter("password"));
		dao.save(user);
		return "registered";
	}*/
	
		/*
		//Mid level implementation
		//Method to process registration request
		@RequestMapping(value="/register.spring",
				method=RequestMethod.POST)
		public String register(
			@RequestParam("name") String n,
			@RequestParam("mailId") String m, 
			@RequestParam("password") String p)
		throws Exception
		{
			User user=new User();
			user.setName(n);
			user.setMailId(m);
			user.setPassword(p);
			dao.save(user);
			return "registered";
		}*/
	
			//High level implementation
			//Method to process registration request
			@RequestMapping(value="/register.spring",
					method=RequestMethod.POST)
			public ModelAndView register(
			@Valid	@ModelAttribute	User user,
			BindingResult result)
			throws Exception
			{
				ModelAndView mav=new ModelAndView();
				//custom validation is applied
				mailValidator.validate(user,result);
				if(result.hasErrors())
				{
					mav.setViewName("regForm");	
					mav.addObject("user",user);
				}
				else
				{
				dao.save(user);
				mav.setViewName("registered");
				}
				return mav;
			}
			
	//Method to serve registration from
	@RequestMapping(value="/regForm.spring")		
	public ModelAndView regForm()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("regForm");	
		mav.addObject("user",new User());
		return mav;
	}
}











