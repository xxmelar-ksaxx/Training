package XML_Confguration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import Connection.AOP_Advisees;

//extends WebMvcConfigurerAdapter
@Configuration
@ComponentScan({"DAL" ,"XML_Confguration", "Connection"})
@EnableAspectJAutoProxy
//@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");  // WEB-INF
		vr.setSuffix(".jsp"); 

		
		return vr;
	}
	
	
	
	@Bean
	public AOP_Advisees aOP_Advisees() {
		
		System.out.println("  Bean runs !!! ");
		
		return new AOP_Advisees();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/myres/**").addResourceLocations("/resources/");
	}
	
	
}
