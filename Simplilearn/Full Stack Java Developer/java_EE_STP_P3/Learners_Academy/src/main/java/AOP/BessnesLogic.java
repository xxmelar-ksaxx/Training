package AOP;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class BessnesLogic {
		
		@Resource
		private BessnesLogic BL; 
	
		public String show () {
		
		System.out.println("hello world");
		BL.d2("none");
		 
		 return "  # helloo from show , Returned val";
		}
		
		public String d1() {
			System.out.println("d1 is called");
			return "  # helloo from d1 , Returned val";
		}
		
		
		public String d2(String o) {
			
			System.out.println("d2 is called , o -> "+o);
			
			
			
			return "  # helloo from d2 , Returned val";
		}
	
	
}
