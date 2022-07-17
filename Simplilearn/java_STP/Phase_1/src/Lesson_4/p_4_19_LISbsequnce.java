// Yousif Al-Dhfeery

package Lesson_4;

import java.util.ArrayList;


public class p_4_19_LISbsequnce {

	  final static int ArraySize = 100;
	
	
	// genrate a random number
	public static int randomNo() {
		  int min = -99;
	      int max = 99;
	        
	      //Generate random int value from 50 to 100 
	      
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      return random_int;
	}
	
	// Create array of random numbers
	public static int[] ranomArray() {
	
		  int[] arr = new int[ArraySize];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = randomNo(); // storing random integers in an array
	      }
	      return arr;
	}
	
	// Find the Longest Increasing Subsequence
	public static void findLIS() {
		
		int[] RandomArray= ranomArray();   // The random array gnerated
			  
		int finalSize=0;                                             // Max Subsequence size found yet
		ArrayList<Integer> finalArray = new ArrayList<Integer>();    // Max Subsequence List found yet
		
		for(int i=0 ; i < RandomArray.length;i++) {                  // to iterate the random array
			
			int tempSize=0;
			ArrayList<Integer> tempArray = new ArrayList<Integer>();
		
				for(int j=i; j < RandomArray.length-1 ;j++) {        // iterate to find the max subsequence size posible  
					if(j == i) {                                     // add the first element the the array
						tempArray.add(RandomArray[j]);
						tempSize++;
						
					}
					
					int LargerValue=0;
					for(int x : tempArray) {                       // get the max value in the temprary array
						if(x > LargerValue) {
							LargerValue = x;
						}
					}
					
					
					if(RandomArray[j+1]>=LargerValue ) {          //  add to temprary array, new bigger value found
						tempArray.add(RandomArray[j+1]);
						tempSize++;
						
					}
				}// End j loop
			
			
			if(tempSize > finalSize) {                        // swap with final array the new bigger array found
				finalSize = tempSize;
				finalArray= tempArray;
			}
			
			
		}// End i loop
		
		System.out.println("Final Size: "+finalSize);
		System.out.println("Final List: "+finalArray);
		
		
	}
	

	public static void main(String[] args) {
		
		findLIS();
		
	}
}
