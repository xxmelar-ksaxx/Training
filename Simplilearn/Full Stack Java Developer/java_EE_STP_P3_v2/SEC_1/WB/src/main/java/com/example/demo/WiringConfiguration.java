package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiringConfiguration {
	
	@Bean(initMethod = "init", destroyMethod = "destroyed")
	public PlainSimpleLogic plainSimpleLogic() {return new PlainSimpleLogic();}
}
