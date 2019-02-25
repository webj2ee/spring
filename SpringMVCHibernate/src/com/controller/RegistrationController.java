package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.model.Registration;
import com.service.RegistrationService;

public class RegistrationController extends SimpleFormController {	

	private RegistrationService registrationService;
	
	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	public RegistrationController() {
		setCommandClass(Registration.class);
		setCommandName("registration");
	}

	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command, BindException errors) throws Exception {
		Registration registration = (Registration)command;
		registrationService.add(registration);
		return new ModelAndView(getSuccessView());
	}
}