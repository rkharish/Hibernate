package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Cars;


public class FetchMobile {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the mobile id");
		int cid=scanner.nextInt();
		
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		//fetch the session
		Session session=sessionFactory.openSession();
		Cars entity=(Cars)session.load(Cars.class,cid);
		System.out.println(entity);
		
	}
}
