// Yousif Al-Dhfeery

package Lesson_2;

public class p_2_5_Constructer {

	
	public p_2_5_Constructer() {

		System.out.println("In the Constructer");
	    
		print();  // a method call
	
	}
	
	public void print() {
		System.out.println("hello");
		
	}
	
	
	public static void main(String[] args) {
		
		new p_2_5_Constructer();
		
	}
	
}
