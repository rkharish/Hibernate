package com.hibernate.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Address;
import com.hibernate.model.Cars;
import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class ManyToMany {

	public static void main(String[] args) {
		
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		Person p = new Person();
		p.setAge(23);
		p.setEmail("yahoo@gmail.com");
		p.setGender("male");
		p.setMobile("1111356789");
		p.setName("Adams");
		
		Passport pass = new Passport();
		pass.setCountry("India");
		pass.setPassno("1111132");
		////Person is parent here
		pass.setPerson1(p);
		
		Cars car = new Cars();
		car.setBrand("Honda");
		car.setColor("blue");
		car.setModel("335i");
		////Person is parent here
		car.setPerson(p);
		
		Cars car2 = new Cars();
		car2.setBrand("Toyota");
		car2.setColor("black");
		car2.setModel("R8");
		////Person is parent here
		car2.setPerson(p);
		
		List<Cars> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car2);
		
		p.setCar(cars);
		
		Address ad = new Address();
		ad.setCity("Fremont");
		ad.setPincode("1334124");
		ad.setStreet("CommAve");
	
		Address ad1 = new Address();
		ad1.setCity("Bangalore");
		ad1.setPincode("23232124");
		ad1.setStreet("Beethovan");
		
		Set<Address> addresses=new HashSet<>();
		addresses.add(ad);
		addresses.add(ad1);
		
		Person p1 = new Person();
		p1.setAge(33);
		p1.setEmail("gmailo@gmail.com");
		p1.setGender("Female");
		p1.setMobile("3434346789");
		p1.setName("Lowrey");
		
		p.setAddresses(addresses);
		p1.setAddresses(addresses);
		
		/////////////KEY/////////////
		
		
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(pass); //here we are persisting person with passport
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		session.save(p1); //here we are saving person independently 
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");

	}

}
