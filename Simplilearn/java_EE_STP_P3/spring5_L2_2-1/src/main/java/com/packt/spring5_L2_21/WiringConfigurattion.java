package com.packt.spring5_L2_21;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WiringConfigurattion {
	
	@Bean(initMethod = "init", destroyMethod = "destroyed" )
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PlainSimpleLogic2 plainSimpleLogic2() {
		return new PlainSimpleLogic2();
	}
	
}
