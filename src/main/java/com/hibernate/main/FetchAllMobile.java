package com.hibernate.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Cars;


public class FetchAllMobile {
	
	public static void main(String[] args) {
		
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		//fetch the session
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cars");
		List<Cars> list=query.list();
		for(Cars entity:list){
			System.out.println(entity);
		}
		
		
	}
}
