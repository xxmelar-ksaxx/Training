// Yousif Al-Dhfeery

package Lesson_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collections;



import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 


public class p_3_16_FileHandling {

	
	// Create  a file
	public void CreateFile(String filename) throws IOException{
		
		File file= new File(filename+".txt"); // path: in the project directory
		
		if(file.createNewFile()) {
			System.out.println("File ("+filename+") Created.");

		}
		else {
			System.out.println("File alrasy exist !!");
		}
		
		
	}
	
		// Read a file
	  public static List<String> readFileInList(String fileName) 
	  { 
	  
	    List<String> lines = Collections.emptyList(); 
	    try { 
	      lines =  Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);     // Read all the lines
	     } 
	  
	    catch (IOException e)  { 
	      //e.printStackTrace();
	    	System.out.println("\n Read file error !! \n");
	    } 
	    
	    return lines; 
	  } 

	  
	  // Append to a file
	  public void appendToFile(String filePath, String appendedContent) {
		     File fileToBeModified = new File(filePath);
		        String oldContent = "";
		        BufferedReader reader = null;
		        FileWriter writer = null;
		        try
		        {
		            reader = new BufferedReader(new FileReader(fileToBeModified));
		            String line = reader.readLine();     // Read the line
		            while (line != null)                                            // While loop to get the text line by line
		            {
		                oldContent = oldContent + line + System.lineSeparator();     
		                line = reader.readLine();                                  
		            }
			            
		                String newContent = oldContent + appendedContent;
			            writer = new FileWriter(fileToBeModified);
			            writer.write(newContent);
		        }
		            catch (IOException e){
		            	 System.out.println("File append error");
		            }
			        finally
			        {
			            try
			            {
			                reader.close();
			                writer.close();
			            } 
			            catch (IOException e) 
			            {
			                e.printStackTrace();
			            }
			        }
	  }
	  
	  
	   public void mainMnue() {
		   System.out.print("\n-- Main Mnue --\n"
				   +" 1-Create a file\n"
				   + " 2-Read a file\n"
				   + " 3-Write to a file (Append)\n"
				   + " 4-Exit\n"
		   		+ "\n Select Option No: ");
		  
		   // The scanner kb
		   Scanner kb = new Scanner(System.in);
		   int userInput=0;
		   try {
			    userInput=kb.nextInt();
			    
			    if(userInput < 1 || userInput > 4) {                         //  Range boundry
			    	System.out.println("No out of range!!. Plese try agin");
					mainMnue();
			    }
		   }
		   catch (Exception e) {
			System.out.println("Wrong input !!. Plese try agin");
			mainMnue();
		}
		   
		   
		  // The options switch block
		  switch(userInput) {
		    
		  	// ------------------------------------  
		  	// To crate a file
		  	case 1:  
				  System.out.println("## Create a file");
				  System.out.print("Enter the file name: ");
				  
				  try {
					  String filename = kb.next();	
					  
					  CreateFile(filename);
					  
					  
					  
				} catch (Exception e) {
					   System.out.println("Error!! try agin");
					   mainMnue();
				}
				  
				  mainMnue();
				  break;
			  
		  	// ------------------------------------
		  	// To read a file
		  	case 2:
				  System.out.println("## Read a file ##");
				  System.out.print("Enter the file name to read: ");
					  try {
						  String filename = kb.next();	
						  
						 List l = readFileInList(filename+".txt");
						Iterator<String> itr = l.iterator();          // iterator to print the lines one by one
						    while (itr.hasNext()) 
						      System.out.println(itr.next()); 
						  
						  
					  } catch (Exception e) {
						   System.out.println("Error!! try agin");
						   mainMnue();
					  }
				  
				  mainMnue();
				  break;
			// ------------------------------------
			// Write to a file (Append)
			case 3:
				  System.out.println("## Append to a file ##");
				  System.out.print("Enter the file name: ");
					  try {
						  String filename = kb.next();	
						  System.out.print("\nEnter text to append: ");
						  String newText = kb.next();
						  
						  appendToFile(filename+".txt", newText);
						  
						  
						  
					  }  
					   catch (Exception e) {
						   System.out.println("Error!! try agin");
						   mainMnue();
					}
					  
				  mainMnue();
				  break;
			// ------------------------------------
		    // To close to program
			case 4:
				  System.out.println("\nExit.");
				  System.exit(0);
				  break;
		  }
		   
		   
		   
	   }
	
	
	public static void main(String[] args) throws IOException {
		p_3_16_FileHandling b1 = new p_3_16_FileHandling();
		
	    b1.mainMnue();
		
	}
	
}
