package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.model.Registration;
import com.model.Registration;

public class RegistrationFormValidator implements Validator {
	public boolean supports(Class clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}
	public void validate(Object obj, Errors errors) {
		Registration registration = (Registration) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.blank.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.blank.password");
	}
}