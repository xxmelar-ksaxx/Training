package DAL;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.webresources.FileResource;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
//@RequestMapping("resurcess")
public class General_Imports implements WebMvcConfigurer {

	
	@Resource
	private General_Imports AD;
	
	
//	@RequestMapping("/Login")
//	public String login(HttpServletResponse response) throws IOException {
//		System.out.println("In Login.jsp");
//		
//	
//		return "Login.jsp";
//		
//	}
//	
//	@RequestMapping("/css")
//	public String home(HttpServletResponse response) throws IOException {
//		System.out.println("In css.css");
//		
//	
//		return "css.css";
//		
//	}
//	

	
	



	
}
