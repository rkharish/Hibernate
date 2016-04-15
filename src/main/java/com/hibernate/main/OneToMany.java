package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Cars;
import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class OneToMany {

	public static void main(String[] args) {
		//@SuppressWarnings("deprecation")
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		

		Person p = new Person();
		p.setAge(21);
		p.setEmail("yahoo@gmail.com");
		p.setGender("female");
		p.setMobile("11356789");
		p.setName("Amy Adams");
		
		Passport pass = new Passport();
		pass.setCountry("India");
		pass.setPassno("2133432");
		////Person is parent here
		pass.setPerson1(p);
		
		Cars car = new Cars();
		car.setBrand("BMW");
		car.setColor("blue");
		car.setModel("335i");
		////Person is parent here
		car.setPerson(p);
		
		Cars car2 = new Cars();
		car2.setBrand("Audi");
		car2.setColor("black");
		car2.setModel("R8");
		////Person is parent here
		car2.setPerson(p);
		
		List<Cars> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car2);
		
		
		/////////////KEY/////////////
		p.setCar(cars);
		
		//fetch the session
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(pass);
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
		

		}

}