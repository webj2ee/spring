package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Adder {

	@RequestMapping("/add.spring")
	public ModelAndView add(
		@RequestParam("num1")	int x, 
		@RequestParam("num2") int y)
	{
		
		int z=x+y;
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sum");
		mav.addObject("result",z);
		return mav;
	}
}









