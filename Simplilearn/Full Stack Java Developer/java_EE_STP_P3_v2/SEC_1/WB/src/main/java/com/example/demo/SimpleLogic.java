package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SimpleLogic implements InitializingBean {
	
	public SimpleLogic() {
		System.out.println("Simple_Logic Class was created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Simple_Logic Class was initilised");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("Class was initilized in afterPropertiesSet");
	}
	
	@PreDestroy
	public void destroyed() {
		System.out.println("Bean is about to be destroyed");
	}
}
