package DAL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("Login/")
public class Admin_Dispatcher {

	
	@Resource
	private Admin_Dispatcher AD;
	
	
	@RequestMapping("Validate_Login")
	public Object login(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		
		String name = request.getParameter("username");
        String password = request.getParameter("password");

        if(ckeckUser(name, password)) {
        	mv.setViewName("MainPage");   // HTML/JSP  Target page
        	mv.addObject("res","The result value");    // send values to the page
        }else {
        	System.out.println("is Empty !! --> Validate user");
        	mv.setViewName("../Login");   // HTML/JSP  Target page
        	mv.addObject("UserState",true);    // send values to the page
        }
    
		return mv;
	}
	
	public boolean ckeckUser(String name, String password) {
		Object ListOfProducts=AD.sendObject("read","select id, name , password from Adminstorator where name=\'"+name+"\' and password=\'"+password+"\'");   // send the request to database.
		ArrayList<Object[]> lis=(ArrayList<Object[]>)ListOfProducts;
		
		if(lis.isEmpty()) {
			System.out.println("is Empty !! ");
			return false;
		}else {
			System.out.println("Q Result = "+lis.get(0)[1]);
			return true;
		}
	}

	@RequestMapping("Validate_Login2")
	public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("username");
        String password = request.getParameter("password");
		
		response.setHeader("Content-Type", "text/plain");
		response.setHeader("success", "yes");
		PrintWriter writer = response.getWriter();
		
		if(ckeckUser(name, password)) {
			writer.write("true");			
		}else {
			writer.write("false");
			System.out.print("  --> ajax ckeck user");
		}
	    writer.close();
	    
	}
	

	
	@RequestMapping("RefreshProductsList")
	public ModelAndView getListofProducts(HttpServletRequest request, HttpServletResponse response) {
		
		
		Object ListOfProducts=AD.sendObject("read","select id, name ,price, category , image from Products");   // send the request to database.
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("AddNewProduct");   // HTML/JSP  Target page  
		
		mv.addObject("ListOfProducts",ListOfProducts);    // send values to the page
		
	
		return mv;
		
	}
	
	@RequestMapping("DeleteProduct")
	public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response) {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Object ListOfProducts=AD.sendObject("delete","DELETE from Products WHERE "+id+"= id");   // send the request to database.
		
//		Products u=new Products(); // Create new row, of type product.
//		u.setId(id);
		
//		Object k=AD.sendObject("delete",u);   // send the row to database.
		
		//ModelAndView mv=new ModelAndView();
		
		//mv.setViewName("AddNewProduct");   // HTML/JSP  Target page  
		
		//mv.addObject("ListOfProducts",null);    // send values to the page
		//getListofProducts(request,response);
	
		return getListofProducts(request,response);
		
	}
	

	
	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
