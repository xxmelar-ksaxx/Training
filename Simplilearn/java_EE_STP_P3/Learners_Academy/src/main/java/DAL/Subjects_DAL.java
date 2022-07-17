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

@Controller
//@RequestMapping("DAL")
public class Subjects_DAL {
	
	@Resource
	private Subjects_DAL SD;
	
	// Return Subjets page
	@RequestMapping("Subjects")
	public Object login(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		return SubjectsPage();
	}
	//Home page MainPage
	@RequestMapping("MainPage")
	public Object mainpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("MainPage");
		return mv;
	}
	//About page UsersAbout
		@RequestMapping("UsersAbout")
		public Object aboutpage(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {		
			ModelAndView mv=new ModelAndView();
			mv.setViewName("UsersAbout");
			return mv;
		}
	
	// Save new subject
	@RequestMapping("SubjectsSave")
	public Object saveNew(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String name = request.getParameter("subject_input");
        String credits = request.getParameter("credits_input");
        Subjects s=new Subjects(name,Integer.parseInt(credits));
        SD.sendObject("insert", s);
		return SubjectsPage();
	}
	
	@RequestMapping("deleteSubject")
	public Object deleteRow(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		Subjects s=new Subjects();
		s.setId(Integer.parseInt(request.getParameter("id")));
		SD.sendObject("delete", s);
		return SubjectsPage(); 
	}
	
	public Object SubjectsPage() throws InterruptedException {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Subjects");   // HTML/JSP  Target page
		List ll= listOfItems();
		
		mv.addObject("SubjectsList",ll);
		return mv;
	}
	
	// returns list of all subjects
	public List listOfItems() {
		List<Object[]> ListOfProducts=(List<Object[]>) SD.sendObject("read","select distinct id, name, credits from Subjects");   // send the request to database.
		//System.out.println("Q Result = "+ListOfProducts.get(0)[1]);
		return ListOfProducts;
	}

	public Object sendObject( String operation, Object entity) {
		
		System.out.println("## In getObject()  ");
		
		System.out.println("## In getObject() , Operation -> "+operation+" , ||  O -> "+entity);
		
		
		return entity;
	}
	
}
