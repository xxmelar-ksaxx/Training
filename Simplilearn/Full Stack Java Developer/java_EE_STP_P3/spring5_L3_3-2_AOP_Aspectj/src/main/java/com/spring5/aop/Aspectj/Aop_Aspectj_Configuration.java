package com.spring5.aop.Aspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Aop_Aspectj_Configuration {

	@Bean
	public Execution_Tracer_Aspect execution_Tracer_Aspect() {
		return new Execution_Tracer_Aspect();
	}
	
	
}
