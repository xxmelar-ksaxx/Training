package com.packt.spring5_L2_21;



import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;



public class PlainSimpleLogic2 implements InitializingBean{
	
	@Autowired
	private SimpleLogic simpleLogic;
	
	public PlainSimpleLogic2() {
		System.out.println("class was created plane");
	}
	
	
	public void init() {
		System.out.println("class was intilizesd plane");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("class was intilizesd in afterProperiniesset  plain"); 
		
	}
	
	
	public void destroyed() {
		System.out.println("Bean is about to be distoyed  plain");
	}
	
	public void doSomeWork() {
		simpleLogic.doSomeWork();
	}
	
}
