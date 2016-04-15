package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class OneToOne {

	public static void main(String[] args) {
		
	//@SuppressWarnings("deprecation")
	AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
	annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
	SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
	

	Person p = new Person();
	p.setAge(21);
	p.setEmail("gmail@gmail.com");
	p.setGender("male");
	p.setMobile("123456789");
	p.setName("Harry");
	
	Passport pass = new Passport();
	pass.setCountry("India");
	pass.setPassno("2133432");
	
	/////////////KEY/////////////
	pass.setPerson1(p);
	
	//fetch the session
	Session session=sessionFactory.openSession();
	session.getTransaction().begin();
	session.save(pass);
	session.getTransaction().commit();
	System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
	

	}

}
