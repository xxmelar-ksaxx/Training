package p1.Spring_AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

	
	@Before("execution(public void show ())")
	public void show () {
		
		System.out.println("Show is called");
		
	}
	
	
	
}
