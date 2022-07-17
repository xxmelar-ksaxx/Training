package com.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring5.aop.Tracible_Service;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Application.class);
		ConfigurableApplicationContext ctx=app.run(args);
		ctx.getBean(Tracible_Service.class).hello("aop");
		
		
		
	}

}
