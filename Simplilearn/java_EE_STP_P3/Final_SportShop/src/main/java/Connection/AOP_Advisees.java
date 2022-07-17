package Connection;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Configuration
@EnableAspectJAutoProxy
public class AOP_Advisees {
	
	private Transaction_Service TS;
	
	@Around("execution(* sendObject*(..)) && args(operation, entity)")
	public Object CRUD (ProceedingJoinPoint pjp, String operation, Object entity) throws Throwable {
		
		System.out.println("## getObject Around Advise triggerd , o ->  "+operation+" || o2 ->  "+entity);
		
		TS =new Transaction_Service();
		Object result=TS.dbTransaction(operation, entity);
		
		//TS=(Transaction_Service) new Transaction_Service().dbTransaction(operation, entity);
		
		
		 
		
		return pjp.proceed(new Object[] {"opration -> "+operation, result});
		
		
	}

}
