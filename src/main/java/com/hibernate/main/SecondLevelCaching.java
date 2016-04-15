package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class SecondLevelCaching {

	public static void main(String[] args) {
		Session session=HibernateSessionManagerUtil.getHibernateSession();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the lid");
		int lid=scanner.nextInt();
	
		///Loading laptop entity first time
		System.out.println("_________________Loading data firsttime__________");
		Laptop laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("Hey  I am going to load same entity!!!!!!!!!!!!!!!!!!!!");
		System.out.println("_________________Loading data second time__________");
		laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		System.out.println("___closing the session____");
		session.close();
		session=HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("__________________Loading data third time____________________");
		laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("__________________Query is not fired so far_____________________");

	}

}
