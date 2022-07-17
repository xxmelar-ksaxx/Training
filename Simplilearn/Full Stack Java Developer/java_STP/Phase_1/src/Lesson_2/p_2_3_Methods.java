// Yousif Al-Dhfeery

package Lesson_2;

public class p_2_3_Methods {
	
	private int x = 10;
	
	// set method, to change the value of x, which is a private variable
	public void set_x(int b) {
		x=b;
		System.out.println("The value of x changed to: "+x);
	}
	
	// get method, to get the value of x, which is a private variable
	public int get_x() {
		return x;
	}
	
	
	public static void main(String[] args) {
		
		p_2_3_Methods s1=new p_2_3_Methods();
		
		System.out.println("The value of x is: "+s1.x);  // print the current value of x
		
		s1.set_x(13);  // change the value of x to 13
		
		int z=s1.get_x(); // get the new value of x
		
		System.out.println("The value of x is: "+z);   // print the new value of x
		
		
		
		
		
	}
	
	

}
