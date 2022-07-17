package com.to;

public class SomeBo {

		public void Validate() {
			System.out.println("Validation stuf from BO");
		}
		
		public void Validate(int age) throws Exception {
			if(age<18) {
				throw new ArithmeticException("Not Valid Age");
			}
			else {
				System.out.println("Vote Conformed");
			}
		}
	
}
