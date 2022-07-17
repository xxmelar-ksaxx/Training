package com.packt.spring5_L2_21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring5L221Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Spring5L221Application.class, args);
		System.out.println(context.getBean(PlainSimpleLogic2.class));
		
		context.getBean(PlainSimpleLogic2.class).doSomeWork();
		System.out.println("Lat msg");
	}
 
}
