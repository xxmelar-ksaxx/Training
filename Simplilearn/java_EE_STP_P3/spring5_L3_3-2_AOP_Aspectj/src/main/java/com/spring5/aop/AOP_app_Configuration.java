package com.spring5.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AOP_app_Configuration {
	
	@Bean
	public Tracible_Service tracible_Service() {
		System.out.println("## @@ ## Bean trasable service in AOP_app_Configuration Class");
		return new Tracible_Service();
	}

}
