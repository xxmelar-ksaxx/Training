package AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

	/*
	@Before("execution(public void show ())")
	public void show () {
		
		System.out.println("Show is called");
		
	}*/
	
	//@Before("execution(* AOP.*.*(..))")
	@Before("execution(* d1*(..))")
	public void show () {
		
		System.out.println("Show is called");
		
		
	}
	
	//@AfterReturning("execution(* d1*(..))")
	@AfterReturning(pointcut="execution(public String d1(..))", returning = "obj" )   //  "execution(* DAL.*.*(..))"
	public void d1 (JoinPoint joinPoint, Object obj) {
		// {result} = the method returned value
		
		
		System.out.println(" func is called ");
		System.out.println(" ++ hh "+obj);
		
	}
	/*
	@Before("execution(* d2*(..))")
	public void send () {
		
		System.out.println("## d2 Before Advise triggerd , ");
		
		
	}*/
	
	@Around("execution(* d2*(..))  &&  args(accountHolderNamePattern)")
	public Object sendv2 (ProceedingJoinPoint pjp, String accountHolderNamePattern) throws Throwable {
		
		System.out.println("## d2 Around Advise triggerd , o ->  "+accountHolderNamePattern);

		return pjp.proceed(new Object[] {"got it"});
		
		
	}

	
	
}
