// Yousif Al-Dhfeery

package Lesson_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static boolean addState = true;   // to disable adding expenses after first call 
	private static  ArrayList<Integer> expenses = new ArrayList<Integer>();
	
    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
    //    ArrayList<Integer> expenses = new ArrayList<Integer>();
        
        if(addState) {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        addState = false;   // to disable adding expenses after first call 
        }
        
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        for(int j=1;j<=slen;j++){
            if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        optionsSelection();

                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        expenses = sortExpenses(expenses);  // sort the expenses
                        optionsSelection();
                        break;
                    case 5:    
                    	searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        System.out.println("Enter the expense you need to search:\t");
        //Complete the method
        Scanner kb=new Scanner(System.in);
        int key = kb.nextInt();              // get value from the user
        
        boolean foundStatefalse = true;   // found state wither found or not

        for(int value : arrayList) {      // iterate through the array

        	if(value == key) {            // check if key found
        		System.out.println("Expenditure found : "+value);
        		foundStatefalse= false;
        		break;
        	}// End if
        }// End for loop
        if(foundStatefalse)             // if key no found
         System.out.println("Expenditure Not found !!");
    }
    private static ArrayList<Integer> sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
       //Complete the method. The expenses should be sorted in ascending order.
       
          // This is my own algorithm, it works fine :) .
        
          for(int i=0; i<arrlength ; i++) {         // iterate the expenses ArrayList
        	  int minValue = arrayList.get(i);      // Minimum value found yet
        	  int minIndex = i;                     // index of minimum value
        	  

        	  for(int j=i; j<arrlength-1; j++) {      // iterate through the unsorted side (right side) of the ArrayList
        		  if(arrayList.get(j+1)< minValue) {  // if minimum value found, update the minValue variable and index


        			  minValue = arrayList.get(j+1);  
        			  minIndex = j+1;
        		  
        		  } // End of if
        		  
        	  }// End of j loop
        	  
        		  arrayList.set(minIndex, arrayList.get(i));   // Swap, current value go to minimum value location 
        		  arrayList.set(i, minValue);				   // Swap, minimum value go to current value location
        		  
        	  
        	  
          }// End of i loop
        
         System.out.println("Sorted list: "+arrayList); 
         return arrayList;
    }
    

    
    
    
    public static void main(String[] args) {
    	/*System.out.println("Hello World!");*/
    	System.out.println("\n**************************************\n");
    	System.out.println("\tWelcome to TheDesk \n");
    	System.out.println("**************************************");
    	optionsSelection();
    	
    }
}
