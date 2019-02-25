package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import dao.UserDao;
import entity.User;

public class MailValidator implements Validator 
{

	//dependency of the validator
	UserDao dao;
	
	
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean supports(Class<?> c) {
		
		return User.class.equals(c);
	}

	@Override
	public void validate(Object model, 
			Errors bindingResult)
	{
		User user=(User)model;
		try
		{
		if(dao.exists(user.getMailId()))
		{
			bindingResult.rejectValue("mailId",
					"error.mailId", 
					"MailId already registered.");
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}

}
