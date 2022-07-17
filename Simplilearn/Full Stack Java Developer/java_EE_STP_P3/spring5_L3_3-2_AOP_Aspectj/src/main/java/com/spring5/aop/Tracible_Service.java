package com.spring5.aop;

public class Tracible_Service {
		
	public void hello(String subject) {
		System.out.println(subject);
		msg();
	}
	
	public void msg() {
		System.out.println("Massage method runs");
	}
}
