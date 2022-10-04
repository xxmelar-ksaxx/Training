package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class PlainSimpleLogic implements InitializingBean {
	
	public PlainSimpleLogic() {
		System.out.println("Simple_Logic Class was created");
	}
	
	 
	public void init() {
		System.out.println("Simple_Logic Class was initilised");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("Class was initilized in afterPropertiesSet");
	}
	
	
	public void destroyed() {
		System.out.println("Bean is about to be destroyed 2");
	}
}
