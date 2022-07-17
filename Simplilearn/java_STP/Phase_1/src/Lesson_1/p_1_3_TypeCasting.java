// Yousif Al-Dhfeery

package Lesson_1;

public class p_1_3_TypeCasting {

	public static void main(String[] args) {

		
		// implicit type casting
		
		int a = 5 ;
		System.out.println("implicit, int a="+a);
		
		double b = a ;
		System.out.println("implicit, int to double b="+b);
		
		// explicit type casting
		
		double c = 5 ;
		System.out.println("explicit, double c="+c);
		
		int d = (int)c ;
		System.out.println("explicit, double to int d="+d);
		
	}
	
}
