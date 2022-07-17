package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class control_1 {

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		int i =Integer.parseInt(request.getParameter("t1"));
		int j =Integer.parseInt(request.getParameter("t2"));
		
		int k=i+j;
		System.out.println(" im in serv");
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("res");   // HTML/JSP  Target page  
		
		mv.addObject("result",k);    // send values to the page
		
		return mv;
		
	}
	
}
