package DAL;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Entities.Products;

import java.util.Base64.Encoder;
import java.util.List;

@Controller
@RequestMapping("AdminPages")
public class Admin_Dispatcher {

	
	@Resource
	private Admin_Dispatcher AD;
	
	
	@RequestMapping("Admin_addNew")
	public ModelAndView saveProduct(HttpServletRequest request, HttpServletResponse response) {
		
		// Get product attributes
		String name =request.getParameter("product_name");
		String price =request.getParameter("product_price");
		String catigory =request.getParameter("product_category");
		String image =request.getParameter("product_image");
		
		
//		// The process to save image data
//		// Starts -----
//		File file = new File(image);
//		byte[] bFile = new byte[(int) file.length()];
//		
//		try {
//			FileInputStream fileInputStream = new FileInputStream(file);
//			//convert file into array of bytes
//			fileInputStream.read(bFile);
//			fileInputStream.close();
//		} catch (Exception e) { 
//			e.printStackTrace(); 
//		}
//		// after this step, the image is in form of bytes, and 
//		//ready to be saved, from the variable {bFile}
//		
//		//The process to save image data
//		// Ends ---- 
//		
//		
//		String encodedString="none. no image";
//		Base64 b64= new Base64();
//		try {
//			encodedString = b64.encodeBase64String(bFile);
//			
//		} catch (Exception e) {
//			System.out.println("Error! -> from Base64 try block");
//		}
		String encodedString=PrepareImageForSavingToBase64(image);
		
		Object u=(new Products(name, price,catigory, encodedString)); // Create new row, of type product.     
		
		Object k=AD.sendObject("insert",u);   // send the row to database.
		
		
		
		System.out.println(" im in serv");
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("AddNewProduct");   // HTML/JSP  Target page  
		
		mv.addObject("img_result",encodedString);    // send values to the page
		
	
		return mv;
		
	}
	
	public String PrepareImageForSavingToBase64(String image) {
		
		// The process to save image data
				// Starts -----
				File file = new File(image);
				byte[] bFile = new byte[(int) file.length()];
				
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					//convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) { 
					e.printStackTrace(); 
				}
				// after this step, the image is in form of bytes, and 
				//ready to be saved, from the variable {bFile}
				
				//The process to save image data
				// Ends ---- 
				
				
				String encodedString="none. no image";
				Base64 b64= new Base64();
				try {
					encodedString = b64.encodeBase64String(bFile);
					
				} catch (Exception e) {
					System.out.println("Error! -> from Base64 try block");
				}

		
		return encodedString;
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
		
		Products u=new Products(); // Create new row, of type product.
		u.setId(id);
		
		Object k=AD.sendObject("delete",u);   // send the row to database.
		
		//ModelAndView mv=new ModelAndView();
		
		//mv.setViewName("AddNewProduct");   // HTML/JSP  Target page  
		
		//mv.addObject("ListOfProducts",null);    // send values to the page
		//getListofProducts(request,response);
	
		return getListofProducts(request,response);
		
	}
	
	@RequestMapping("EditProduct")
	public ModelAndView editProduct(HttpServletRequest request, HttpServletResponse response) {
	
		// Get product attributes
		int id = Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		String price =request.getParameter("price");
		String catigory =request.getParameter("catigory");
		String image =request.getParameter("image");
		
		//Object ListOfProducts=AD.sendObject("delete","DELETE from Products WHERE "+id+"= id");   // send the request to database.
		
		//String encodedString=PrepareImageForSavingToBase64(image);
		
		//Products u=new Products(10 ,name, price,catigory, "none any no"); // Create new row, of type product.
		
		//Object k=AD.sendObject("update",u);   // send the row to database.
	
		List ListOfProducts=(List) AD.sendObject("read","select image from Products where id="+id+"");   // send the request to database.
		
	
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("EditProduct");   // HTML/JSP  Target page  
		
		mv.addObject("setId",id);
		mv.addObject("setName",name);    // send values to the page
		mv.addObject("setPrice",price);
		mv.addObject("setCatigory",catigory);
		mv.addObject("setImage",ListOfProducts.get(0));
	
		return mv;
		
		//return getListofProducts(request,response);
		
	}
	
	@RequestMapping("Admin_updateProduct")
	public ModelAndView updateProducts(HttpServletRequest request, HttpServletResponse response) {
		
		// Get product attributes
		int id = Integer.parseInt(request.getParameter("product_id"));
		String name =request.getParameter("product_name");
		String price =request.getParameter("product_price");
		String catigory =request.getParameter("product_category");
		String image =request.getParameter("product_image");
		
		String encodedImageString=PrepareImageForSavingToBase64(image);
		
		Products u=new Products(id, name, price, catigory, encodedImageString);
		
		Object k=AD.sendObject("update",u);   // send the request to database.
		
		u=null; // to flush memory for future products edit 
		
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("AddNewProduct");   // HTML/JSP  Target page  
	
		
		return getListofProducts(request, response);
		
	}
	
	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
	
	
}
