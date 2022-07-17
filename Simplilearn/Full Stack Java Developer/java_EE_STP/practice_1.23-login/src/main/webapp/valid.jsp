<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	
			body{
					background-color: #540B0E;
			}
	
			#logout {
					  background-color: #197278;
					  border: none;
					  color: #EDDDD4;
					  padding: 3px 30px;
					  text-decoration: none;
					  margin: 4px 2px;
					  cursor: pointer;
					  font-family: Segoe UI;
					  font-size: 20px;
					  
					  margin-left: 87%;
					
					  
					  
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
					margin-top: 10%;
			}
			
		
			
	</style>



</head>
<body>
			<h1>Welcome <% out.print(request.getAttribute("name")); %> </h1> 
			
			<a id="logout" href="logout" >Log-out</a>
			
			<br/> 
			<hr class="new5">
		
		
		
		<div id="myinfo"> 
			@ Developed By: Yousif Al-Dhfeery <br/>
			@ GitHub: https://github.com/xxmelar-ksaxx
	
	</div>
			


</body>
</html>