package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;







import Connection.Connect;


public class Product_DAL {

	

		//@SuppressWarnings("unchecked")
		public List getProduct(String pid) {

			List<Object[]> product = new LinkedList();
	        try (Connection con =Connect.getConnection()){
	            
	        	Statement statement=con.createStatement();
	            
	            String select="select P.id, P.name, P.price from products P where P.id='"+pid+"' ";
	            
	            ResultSet rs=statement.executeQuery(select);
	            
	            
	            // add elements to the List:product
	            while(rs.next()) {   
	            	Object[] oa= {rs.getString(1),rs.getString(2),rs.getString(3)};
	            	product.add(oa);
	            	
	            	
	            	
	            	//product=product;
	            }
	            
	            //con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return product;
	    }

	
}
