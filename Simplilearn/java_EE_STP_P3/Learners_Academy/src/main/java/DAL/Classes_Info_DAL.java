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

import Entities.Classes;
import Entities.Subjects;

@Controller
//@RequestMapping("Classes_Info_DAL")
public class Classes_Info_DAL {
	
	@Resource
	private Classes_Info_DAL SD;
	
	// Return Classes page
	@RequestMapping("Classes_Info")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {	
		String class_id= request.getParameter("class_info_id");
		return ClassesPage(class_id);
	}
//	//Home page MainPage
//	@RequestMapping("Classes_Info/MainPage")
//	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("MainPage");
//		return mv;
//	}

	public Object ClassesPage(String id) throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Class_info");   // HTML/JSP  Target page
		List ll= listOfItems();
		List CInfo= listOfCInfo(id);
		
		for(Object[] ok:(List<Object[]>) CInfo) {
			System.out.println(ok[0]);
		}
		mv.addObject("ClassesList",ll);
		mv.addObject("ClassesInfoList",CInfo);
		return mv;
	}
	
	// returns list of all classes
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select C.id, S.name, C.roomNo, C.time from Classes C, Subjects S where C.f_name=S.id");   // send the request to database.
		return ListOfProducts;
	}
	public List listOfCInfo(String class_id) {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select distinct S.name, C.roomNo,T.name ,count(ST.id) from Entities.Classes C, Entities.Students ST, Entities.Subjects S, Entities.Teachers T, Entities.Teachers_Classes TC where S.id=C.f_name and ST.class1=C.id and ST.class1='"+class_id+"' and C.id=TC.c_id");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}

	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
