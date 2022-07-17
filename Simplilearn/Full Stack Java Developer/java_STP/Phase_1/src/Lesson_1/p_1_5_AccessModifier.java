// Yousif Al-Dhfeery

package Lesson_1;


//Public codifier
public class p_1_5_AccessModifier {
	
	public static void main(String[] args) {
		
	   a1 x=new a1(); 
	   x.display(); // access the default modifier
	   
	   a2 y=new a2();
	   System.out.println("Try to access privet, throwes error!!");
	   //y.display();  // access the private modifier, Error oucors
	   	
	   a3 z=new a3();
	   z.display();     // access the protected modifier
	   
	}

}

// default modifier	
class a1{  	

	void display(){
		System.out.println("default modifier class");
	}
	
}

// Private modifier
 class a2{
	 private void display(){
			System.out.println("private modifier class");
		}
	
}

 // protected modifier
 class a3{
	 protected void display(){
			System.out.println("protected modifier class");
		}
	 
 }

