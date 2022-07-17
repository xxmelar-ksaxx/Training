// Yousif Al-Dhfeery

package Lesson_2;

import java.util.*;

public class p_2_18_EmailValidation {

	
		ArrayList<String> emails= new ArrayList<String>();
		
		
		// Check if the email exist
		public boolean emailChcker(String x) {
			
			String String_state="Not found !!";    // The printed massage
			boolean state=false;                   // The state wither Found of Not
			
			for(String ch : emails ) {             // Array iterator	
				if(ch.equals(x)) {
					
					String_state="found : "+ch;
					state = true;
					
				}							
			}
			System.out.println(String_state);
			return state;
		}
		
		public void mainMenu(Scanner kb) {
			System.out.print("Please enter an email: ");
			String email = kb.nextLine();                  // The entered email
			
			boolean state = emailChcker(email);
			
			if(state == false) {
				mainMenu(kb);
			}
			
		}
		
		public static void main(String[] args) {
			
			p_2_18_EmailValidation b1 = new p_2_18_EmailValidation();
			
			b1.emails.add("abc@gmail.com");
			b1.emails.add("def@gmail.com");
			b1.emails.add("ghi@gmail.com");
			b1.emails.add("jkl@gmail.com");
			
			//b1.emailChcker("abc@gmail.com");
			
			Scanner kb = new Scanner(System.in);
			
			b1.mainMenu(kb);     // Run the Main Menu 			
		
		}
	
}
