// Yousif Al-Dhfeery

package Lesson_1;

public class p_1_6_arthmaticCalculator {

	public void addition(int x,int y) {
		System.out.println("Addition of:"+x+" + "+y+" = "+(x+y));
	}
	
	public void substract(int x,int y) {
		System.out.println("Subtraction of:"+x+" - "+y+" = "+(x-y));
	}
	
	public void multibly(int x,int y) {
		System.out.println("Multiplication of:"+x+" X "+y+" = "+(x*y));
	}
	
	public void devide(int x,int y) {
		System.out.println("Division of:"+x+" / "+y+" = "+(x/y));
	}
	
	
	public static void main(String[] args) {
		p_1_6_arthmaticCalculator a1=new p_1_6_arthmaticCalculator();
		
		a1.addition(5, 3);   // Addition
		a1.substract(5, 3);  // Subtraction
		a1.multibly(5, 3);   // Multiplication
		a1.devide(10, 5);	 // Division
	}
	
}
