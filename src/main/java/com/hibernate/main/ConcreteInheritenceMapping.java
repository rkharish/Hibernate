package com.hibernate.main;

import org.hibernate.Session;

import com.hibernate.model.NonVegPizza;
import com.hibernate.model.Pizza;
import com.hibernate.model.VegPizza;
import com.hibernate.util.HibernateSessionManagerUtil;

public class ConcreteInheritenceMapping {

	public static void main(String[] args) {
		Session session = HibernateSessionManagerUtil.getHibernateSession();
		session.getTransaction().begin();
		
		Pizza pizza = new Pizza();
		pizza.setBase("thin crust");
		pizza.setDescription("my fav!");
		pizza.setSize("large");
		pizza.setType("Stylish");
		pizza.setPid(100);
		
		NonVegPizza nonVegPizza = new NonVegPizza();
		nonVegPizza.setBase("handmade pan");
		nonVegPizza.setDescription("great taste!");
		nonVegPizza.setMeatType("chciken");
		nonVegPizza.setPid(200);
		nonVegPizza.setPrice(400);
		nonVegPizza.setSize("medium");
		nonVegPizza.setToppings("onion, garlic, peppers");
		nonVegPizza.setType("Stylish");
		
		VegPizza vPizza = new VegPizza();
		vPizza.setBase("buttery crust");
		vPizza.setDescription("good for health");
		vPizza.setPid(300);
		vPizza.setPrice(250);
		vPizza.setSize("medium");
		vPizza.setToppings("potato, onion, pepper");
		vPizza.setType("healthy");
		
		session.save(pizza);
		session.save(nonVegPizza);
		session.save(vPizza);
		
		session.getTransaction().commit();

	}

}
