<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
		
		<style>
			
			body{
						background-color: #540B0E;
				}
			
			a:link, a:visited {
				  background-color: #197278;
				  color: #EDDDD4;
				  
				  padding: 7px 1px;
				  text-align: center;
				  text-decoration: none;
				  display: inline-block;
				  
				  cursor: pointer;
				  font-family: Segoe UI;
				  font-size: 20px;
				  
				  width: 17em;
				  
				  
			}
			
				a:hover, a:active {
				  background-color: #14868E;
				  color: #EDDDD4;
			}
			
			
			h1{
					text-align: center; color: #EDDDD4;
					font-family: Segoe UI;
					font-size: 40px;
			
			}
			hr.new5 {
					  margin-top: -30px;
					  margin-left: 20%;
					  margin-right: 20%;
					  border: 1px solid #EDDDD4;
					  border-radius: 10px;
			}
				#myinfo{
					text-align: left; 
					color: #EDDDD4;
					font-family: Segoe UI;
					font-size: 20px;
					
			}
			
			
			
		</style>

</head>
<body>

		<div style="text-align: center;">
		
			<h1>Main Menu</h1> <br/>
			<hr class="new5">
		
		<br/>
		
		<h2><a href="list" >  List/Add Subject  </a><br/></h2>
		<h2><a href="get_subject_names" >  List/Add Classes   </a><br/></h2>
		<h2><a href="list_teacher" >  List/Add Teachers  </a><br/></h2>
		<h2><a href="list_TC" >  List/Assign The Teachers Classes  </a><br/></h2>
		<h2><a href="list_student" >  List/Add Student  </a><br/></h2>
		
		<h2><a href="class_info_refrech" >  Class information  </a><br/></h2>
		</div>
		
		<div id="myinfo">
			@ Developed By: Yousif Al-Dhfeery <br/>
			@ GitHub: https://github.com/xxmelar-ksaxx
	
		</div>
		
		
</body>
</html>