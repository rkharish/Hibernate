package com.hibernate.main;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class QueryCahcing {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter111 ID for Laptop!");
		int id = scan.nextInt();

		Session session = HibernateSessionManagerUtil.getHibernateSession();
		// starting the transaction
		session.beginTransaction();

		System.out.println("Firing query first time_____________________________________________________________________________________");

		Query query = session.createQuery("from Laptop c where c.id=" + id);
		query.setCacheable(true);
		// query.setCacheRegion("###amog##");
		Iterator it = query.list().iterator();
		while (it.hasNext()) {
			Laptop p = (Laptop) it.next();
			System.out.println("Laptop  =  " + p);
			System.out.println("HashCode()  = " + p.hashCode());
		}
		
		System.out.println("Firing query second time__________________________________________________________________________");
		System.out.println("Firing same query in same session again______________________________________________________________________");
		query = session.createQuery("from Laptop c where c.id=" + id);
		query.setCacheable(true);
		// query.setCacheRegion("###amog##");
		it = query.list().iterator();
		while (it.hasNext()) {
			Laptop p = (Laptop) it.next();
			System.out.println("Laptop  =  " + p);
			System.out.println("HashCode()  = " + p.hashCode());
		}

		session.getTransaction().commit();
		session.close();
		
		System.out.println("Session just Closed__________________________________________________________________________");
		session = HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("Firing query third time__________________________________________________________________________");
		query = session.createQuery("from Laptop c where c.id=" + id);
		// query.setCacheMode(CacheMode.REFRESH);
		query.setCacheable(true);
		// query.setCacheRegion("###amog##");
		it = query.list().iterator();
		while (it.hasNext()) {
			Laptop p = (Laptop) it.next();
			System.out.println("Laptop  =  " + p);
			System.out.println("__#+_#HashCode()  ............ =  " + p.hashCode());
		}

		// session.close();
		// session = HibernateFactoryUtil.openSession();

		Laptop laptop = (Laptop) session.load(Laptop.class, id);
		System.out.println("32424234 = " + laptop);
		System.out.println("__#+_#HashCode()  ............ =  " + laptop.hashCode());

		session.close();
		// After closing the session object will be in detached state.
		System.out.println("Object is fetched");
	}
}
