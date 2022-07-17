package spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import spring5.tx.Busniess_Service;

@SpringBootApplication
public class Spring5L442TransactionManegmentApplication {

	public static void main(String[] args) {
		
		
		SpringApplication app = new SpringApplication(Spring5L442TransactionManegmentApplication.class);
		
		ConfigurableApplicationContext ctx=app.run(args);
		
		ctx.getBean("busniess_Service_Programmatic_Tx", Busniess_Service.class).doBusiness();
		
	}

}
