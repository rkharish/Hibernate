package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FirstLevelCaching {

	public static void main(String[] args) {
		 
		    Session session =HibernateSessionManagerUtil.getHibernateSession();
			
			session.beginTransaction();
			
			
		
			System.out.println("Enter ID for Laptop!");
			Scanner scan=new Scanner(System.in);
			int id=scan.nextInt();
			
			
			Laptop p =(Laptop) session.load(Laptop.class,id);
			System.out.println("laptop data 1= "+p);
			System.out.println(p.hashCode());
			
			p =(Laptop) session.load(Laptop.class,id);
			System.out.println("laptop data 2 = "+p);
			System.out.println(p.hashCode());
			session.getTransaction().commit();
			
			System.out.println("Transaction is commited");
			p =(Laptop) session.load(Laptop.class,id);
			System.out.println("laptop data 3 = "+p);
			System.out.println(p.hashCode());
			
			session.close();
			
			System.out.println("We are creating session again and try to load the same laptop!");
			
			 session = HibernateSessionManagerUtil.getHibernateSession();
			p =(Laptop) session.load(Laptop.class,id);
			System.out.println("laptop data 4 = "+p);
		
			System.out.println(p.hashCode());
			session.close();
			System.out.println("AHAHAHAHAHHA");
				
			System.out.println(p.hashCode());
	}

}
