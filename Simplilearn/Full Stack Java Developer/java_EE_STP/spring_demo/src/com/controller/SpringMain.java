package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.to.Employee;
import com.to.Hello;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		/*Hello h1=(Hello)context.getBean("h1");
		System.out.println(h1.getMessage());
		
		Hello h2=(Hello)context.getBean("h2");
		System.out.println(h2.getMessage());
		*/
		
		Employee e1=(Employee) context.getBean("e2");
		System.out.println(e1);
	}
	
}
