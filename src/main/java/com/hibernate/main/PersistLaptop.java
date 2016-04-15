package com.hibernate.main;

import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class PersistLaptop {

	public static void main(String[] args) {
		 Session session = HibernateSessionManagerUtil.getHibernateSession();
			//starting the transaction
			session.beginTransaction();
			Laptop lp = new Laptop();
			lp.setGeneration("9th");
			lp.setModel("Sony");
			lp.setName("Vaio");
			lp.setPrice(25500);
			lp.setRam("8");
			
			session.save(lp);
			session.getTransaction().commit();
			
			

	}

}
