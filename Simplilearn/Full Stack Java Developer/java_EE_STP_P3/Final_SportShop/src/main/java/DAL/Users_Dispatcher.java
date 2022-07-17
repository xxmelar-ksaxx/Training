package DAL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Entities.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Controller
@RequestMapping("UserPages")
@RestController
public class Users_Dispatcher {

	@Resource
	private Users_Dispatcher UD;
	
	
	// All thing regarding registration process.
	@RequestMapping("register_newUser")
	//@Produces(MediaType.MULTIPART_FORM_DATA)
	public Object regiater_newUser(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Object result=null;
		ModelAndView mv=new ModelAndView();
		Object[] user=(Object[]) check_email_pass(email, password, "register");
		if(user[0].equals("found")) {
				//result="email exsist!";
				mv.setViewName("Register");   // HTML/JSP  Target page  
				mv.addObject("email_state",1);    // send values to the page. State 1 mens email exist
				result=mv;
		}
		else {
			Object newUser= new User(username, email, password, "costomer");
			UD.sendObject("insert", newUser);
			
			mv.setViewName("Login");   // HTML/JSP  Target page  
			mv.addObject("img_result","NO data");    // send values to the page
			result=mv;
		}
		return result;
	}
	
	// All thing regarding registration process.
	@RequestMapping("user_login")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Object user_login(HttpServletRequest request, HttpServletResponse response) {
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			Object result=null;
			
			ModelAndView mv=new ModelAndView();
			Object[] user= (Object[]) check_email_pass(email, password, "login");
			
			System.out.println("User result is= "+user[0]);
			
			
			if(user[0].equals("not_found")) {
					System.out.println("#### ---  user not found");
					mv.setViewName("Login");   // HTML/JSP  Target page  
					mv.addObject("login_state",1);    // send values to the page. State 1 mens wrong inputs
					result=mv;
			}
			else {
				
				// if user found
				if(user[4].equals("costomer")) {
					mv.setViewName("UserMain");   // HTML/JSP  Target page  
					mv.addObject("login_result",user[1]);    // send values to the page
					result=mv;
				}
				else {
					mv.setViewName("../AdminPages/AdminMain");   // HTML/JSP  Target page  
					mv.addObject("user_info",user);    // send values to the page
					result=mv;
				}
				
			}
			
			return result;
	}
	
	// Check if the user exist
	public Object check_email_pass(String email, String pass, String operation) {
		
		Object result="Error. no data -> from {check_email_pass(String email , String pass)}";
		List<Object[]> k=null;
		Object[] oaResult= {"Error. no data -> from {check_email_pass(String email , String pass)}"};
		
		if(operation.equals("register")) {
			k=(List<Object[]>) UD.sendObject("read", "select id, name, email, password, role from User where email='"+email+"'");
		}
		if(operation.equals("login")) {
			k=(List<Object[]>) UD.sendObject("read", "select id, name, email, password, role from User where email='"+email+"' and password='"+pass+"'");
		}
		
		if(k.isEmpty()) {
			Object[] op={"not_found"};
			oaResult= op;
		}
		else {
				if(operation.equals("register")) {
					Object[] op={"found"};
					oaResult=op;
				}
				else if(operation.equals("login")) {
					
					Object[] e=k.get(0);
					System.out.println(e[0]);
					System.out.println(e[1]);
					System.out.println(e[2]);
					System.out.println(e[3]);
					
					oaResult=k.get(0);
				}
		}
		return oaResult;
	}
	
	
	
	@RequestMapping("Register")
	public ModelAndView regiater_newUser_v2(HttpServletRequest request, HttpServletResponse response) {
	
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		List k=(List) UD.sendObject("read", "select email from User where email='"+email+"'");
		
		System.out.println("***___---  k= -"+k+"-");
		if(k.isEmpty()) {
			System.out.println(" #######  -----  is  empty -> email doesn't exist. Good  -------   ####### ");
			//User user=new User();
			
		
		}
		else {
			System.out.println(" #######  -----  email exist !!  Bad  -------   ####### ");
		}
		
		
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Register");   // HTML/JSP  Target page  
		mv.addObject("img_result","NO data");    // send values to the page

		return mv;
		
	}
	
	@GET
	@Path("tt")
	@Produces(MediaType.TEXT_HTML)
	public Response getMessageQueryParam(@QueryParam("param1") String param1) {
		
		//String val=request.getParameter("tx");
		
		//request.setAttribute("txval", val+" changed");
		
		System.out.println("#$$  jason data IS 11?-> ");
		return null;
		
	}
	
	@RequestMapping("w1")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public @ResponseBody String checkIfEmpty(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String str=null;
		str= "Got it!   From w1 boyyyyy";
		String aa=request.getParameter("aa");
		
		
		
		if(aa==null || aa=="none") {
			
			str="is empty man! ";
		}
		else if(aa.equals("")){
			str="is only space";
		}
		
		
		System.out.println("@@ $$ --- aa= -"+aa+"-");
		
		
		return str;
	}
		
	 
	
	
public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
