package p1.Spring_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	
    	BessnesLogic b1=context.getBean(BessnesLogic.class);
    	
    	b1.show();
    	
    }
}
