package com.packt.spring5_L2_21;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogic implements InitializingBean{
	
	public SimpleLogic() {
		System.out.println("class was created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("class was intilizesd");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("class was intilizesd in afterProperiniesset");
		
	}
	
	@PreDestroy
	public void destroyed() {
		System.out.println("Bean is about to be distoyed");
	}

	public void doSomeWork() {
		System.out.println("Work done inside SimpleLogic");
		
	}
	
	
	
}
