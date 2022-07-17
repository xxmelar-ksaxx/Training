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
//@RequestMapping("Classes_DAL")
public class Classes_DAL {
	
	@Resource
	private Classes_DAL SD;
	
	// Return Classes page
	@RequestMapping("Classes")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		return ClassesPage();
	}
//	//Home page MainPage
//	@RequestMapping("Classes/MainPage")
//	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("MainPage");
//		return mv;
//	}
	
	// Save new subject
	@RequestMapping("ClassSave")
	public Object saveNew(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String subj_id = request.getParameter("subject_name");
        String room = request.getParameter("room_no");
        String time = request.getParameter("class_time");
        
        Subjects s=new Subjects();
        s.setId(Integer.parseInt(subj_id));
        Classes c=new Classes(s,Integer.parseInt(room),Integer.parseInt(time));
        
        SD.sendObject("insert", c);
		return ClassesPage();
	}
	
	@RequestMapping("deleteClass")
	public Object deleteRow(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		Classes s=new Classes();
		s.setId(Integer.parseInt(request.getParameter("id")));
		SD.sendObject("delete", s);
		return ClassesPage(); 
	}
	
	public Object ClassesPage() throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Classes");   // HTML/JSP  Target page
		List ll= listOfItems();
		List LSubj= listOfSubjects();
		
		for(Object[] ok:(List<Object[]>) LSubj) {
			System.out.println(ok[0]);
		}
		mv.addObject("ClassesList",ll);
		mv.addObject("SubjectsList",LSubj);
		return mv;
	}
	
	// returns list of all classes
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select C.id, S.name, C.roomNo, C.time from Classes C, Subjects S where C.f_name=S.id");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}
	public List listOfSubjects() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select distinct id, name from Subjects");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}

	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
