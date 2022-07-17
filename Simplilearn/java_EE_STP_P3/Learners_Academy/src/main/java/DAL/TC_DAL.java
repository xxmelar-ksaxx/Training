package DAL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Entities.Classes;
import Entities.Subjects;
import Entities.Teachers;
import Entities.Teachers_Classes;

@Controller
//@RequestMapping("TC_DAL")
public class TC_DAL {
	
	@Resource
	private TC_DAL SD;
	
	// Return TC page
	@RequestMapping("TC")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		return TCPage();
	}
//	//Home page MainPage
//	@RequestMapping("TC/MainPage")
//	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("MainPage");
//		return mv;
//	}
	
	// Save new subject
	@RequestMapping("TCSave")
	public Object saveNew(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String t_name_id = request.getParameter("t_name");
        String class1_id = request.getParameter("c_name");
        Teachers t=new Teachers();
        t.setId(Integer.parseInt(t_name_id));
        Classes c=new Classes();
        c.setId(Integer.parseInt(class1_id));
        Teachers_Classes tc=new Teachers_Classes(t,c);
        SD.sendObject("insert", tc);
		return TCPage();
	}
	
	@RequestMapping("deleteTC")
	public Object deleteRow(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		Teachers_Classes tc=new Teachers_Classes();
		tc.setTC_id(Integer.parseInt(request.getParameter("id")));
		SD.sendObject("delete", tc);
		return TCPage(); 
	}
	
	public Object TCPage() throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("TC");   // HTML/JSP  Target page
		List ll= listOfItems();
		List LC= listOfClasses();
		List LT= listOfTeachers();
		
		mv.addObject("TCList",ll);
		mv.addObject("TeachersList",LT);
		mv.addObject("ClassesList",LC);
		return mv;
	}
	
	// returns list of TC
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select TC.tc_id, T.name, S.name ,C.roomNo, C.time from Teachers T,Classes C, Teachers_Classes TC, Subjects S where TC.t_id=T.id and TC.c_id=C.id and C.f_name=S.id");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}
	
	// returns list of all classes
	public List listOfClasses() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select C.id, S.name, C.roomNo, C.time from Classes C, Subjects S where C.f_name=S.id");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}
	
	// returns list of all Teachers
	public List listOfTeachers() {
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
