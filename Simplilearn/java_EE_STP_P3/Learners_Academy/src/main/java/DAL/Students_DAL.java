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

import Entities.Students;
import Entities.Subjects;
import Entities.Teachers;

@Controller
//@RequestMapping("Students_DAL")
public class Students_DAL {
	
	@Resource
	private Students_DAL SD;
	
	// Return Students page
	@RequestMapping("Students")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		return StudentsPage();
	}
//	//Home page MainPage
//	@RequestMapping("Students/MainPage")
//	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("MainPage");
//		return mv;
//	}
	
	// Save new subject
	@RequestMapping("StudentSave")
	public Object saveNew(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("jender");
        String age = request.getParameter("age");
        String role = "Student";
        String class1 = request.getParameter("class1");
        Students s= new Students(name,email,gender,Integer.parseInt(age),role,Integer.parseInt(class1));
        SD.sendObject("insert", s);
		return StudentsPage();
	}
	
	@RequestMapping("deleteStudent")
	public Object deleteRow(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		Students s=new Students();
		s.setId(Integer.parseInt(request.getParameter("id")));
		SD.sendObject("delete", s);
		return StudentsPage(); 
	}
	
	public Object StudentsPage() throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Students");   // HTML/JSP  Target page
		List LS= listOfItems();
		List LC= listOfClasses();
		
		for(Object[] ook:(List<Object[]>)LS) {
			System.out.println("Students : "+ook[2]);
		}
		
		mv.addObject("StudentsList",LS);
		mv.addObject("ClassesList",LC);
		return mv;
	}
	
	// returns list of all Students
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select distinct ST.id, ST.name, ST.email, ST.jender,ST.age,ST.role, S.name from Students ST, Classes C, Subjects S where ST.class1=C.id and S.id=C.f_name");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}
	// returns list of all classes
		public List listOfClasses() {
			List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select C.id, S.name, C.roomNo, C.time from Classes C, Subjects S where C.f_name=S.id");   // send the request to database.
			//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
			return ListOfProducts;
		}

	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
