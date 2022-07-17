package DAL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.patterns.ArgsPointcut;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Connection.Transaction_Service;
import Entities.User;

@Controller
@RequestMapping("Test")
public class AddUser {
	
	@Resource
	private AddUser addUser;
	
	
	@RequestMapping("addnew")
	public ModelAndView insertNewUser(HttpServletRequest request, HttpServletResponse response, String x1) {
		
		
		String name =request.getParameter("t1");
		String email =request.getParameter("t2");
		String pass =request.getParameter("t3");
		
		Object u=(new User(name, email, pass));     
		String xx="ds";
		
		Object k=addUser.sendObject("insert",u);
		
		System.out.println(" Return -> "+k);
		
		
		
		System.out.println(" im in serv");
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("res");   // HTML/JSP  Target page  
		
		mv.addObject("result","Good");    // send values to the page
	
		return mv;
		
	}
	
	
	
	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		addUser.d2("none","none2");
		
		return entity;
	}
	
	public String d2(String o, String o2) {
		
		System.out.println("d2 is called , o -> "+o+" || o2 -> "+o2);
		
		
		
		return "  # helloo from d2 , Returned val";
	}

	
	
	
}
