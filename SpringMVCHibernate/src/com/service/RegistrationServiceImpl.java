package com.service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.model.Registration;

public class RegistrationServiceImpl implements RegistrationService {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public void add(Registration registration) {
		hibernateTemplate.saveOrUpdate(registration);
		System.out.println(listUser());
	}
	
	public List<Registration> listUser() {
		return hibernateTemplate.find("from Registration");
	}
}
