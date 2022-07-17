package com.spring5.aop.Aspectj;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Execution_Tracer_Aspect {

	@Pointcut("execution(* com.spring5.aop.*.*(..))")
	private void allMethods() {
		System.out.println("## @@ ## Point cut allMethods in Execution_Tracer_Aspect Class");
	}
	
	@Around("allMethods()")
	public Object tracer(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		String signture = pjp.getSignature().toString();
		Object retVal = pjp.proceed(args);
		System.out.println("Method '"+signture+"' was called with newt arguments "+Arrays.toString(args));
		return retVal;
	}
	
	
}
