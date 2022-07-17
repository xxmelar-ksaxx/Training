package XML_Confguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import Connection.AOP_Advisees;
import DAL.AspectHelper;

//extends WebMvcConfigurerAdapter
@Configuration
@ComponentScan({"DAL" ,"XML_Confguration", "Connection"})
@EnableAspectJAutoProxy
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		//vr.setPrefix("/WEB-INF/Test/");  // WEB-INF
		vr.setSuffix(".jsp"); 

		
		return vr;
	}
	
	
	@Bean
	public AspectHelper aspectHelper() {
		
		System.out.println("  Bean runs !!! ");
		
		return new AspectHelper();
	}
	
	@Bean
	public AOP_Advisees aOP_Advisees() {
		
		System.out.println("  Bean runs !!! ");
		
		return new AOP_Advisees();
	}
	
	
}
