package DAL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Entities.Subjects;
import Entities.Teachers;

@Controller
//@RequestMapping("Teachers_DAL")
public class Teachers_DAL {
	
	@Resource
	private Teachers_DAL SD;
	
	// Return Subjets page
	@RequestMapping("Teachers")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		return TeachersPage();
	}
//	//Home page MainPage
//	@RequestMapping("Teachers/MainPage")
//	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("MainPage");
//		return mv;
//	}
	
	// Save new subject
	@RequestMapping("TeacherSave")
	public Object saveNew(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String role = "Teacher";
        Teachers s=new Teachers(name,email,gender,Integer.parseInt(age),role);
        SD.sendObject("insert", s);
		return TeachersPage();
	}
	
	@RequestMapping("deleteTeacher")
	public Object deleteRow(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		Teachers s=new Teachers();
		s.setId(Integer.parseInt(request.getParameter("id")));
		SD.sendObject("delete", s);
		return TeachersPage(); 
	}
	
	public Object TeachersPage() throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Teachers");   // HTML/JSP  Target page
		List ll= listOfItems();
		
		mv.addObject("TeachersList",ll);
		return mv;
	}
	
	// returns list of all Teachers
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select distinct id,name,email,jender,age,role from Teachers");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}

	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
