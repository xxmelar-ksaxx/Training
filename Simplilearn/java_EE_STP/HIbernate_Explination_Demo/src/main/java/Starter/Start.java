package Starter;

import DAL.Product_DAL;
import Entities.Products;

public class Start {

	
	public static void main(String[] args) {
		
		Product_DAL pDal= new Product_DAL();
		
		Products p = new Products("car",1000);
		
		pDal.saveUser(p,"create");
		
	}
	
}
