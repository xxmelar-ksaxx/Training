package DAL;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;


@Aspect
@Configuration
public class AspectHelper {

	
	@After("execution(* insertNewUser*(..))")   //  "execution(* DAL.*.*(..))"
	public void show () {
		
		System.out.println("Show is called @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ######################################## @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
	/*
	@After("execution(* getObject*(..)) && args(obj,obj2)" )
	public void saveNewRow (JoinPoint joinPoint, Object obj, Object obj2) {
		
		System.out.println(" func is called ");
		System.out.println(" ++ obj 1 -- "+obj);
		System.out.println(" ++ obj 2 -- "+obj2);
		
	}*/
	
	
}
