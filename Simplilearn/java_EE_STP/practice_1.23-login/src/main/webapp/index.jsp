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
	
			div{
				
					text-align:   center;
					
			}
			#span1{
					display: inline-block;
					text-align:   left;
					color: #EDDDD4;
					font-family: Segoe UI;
					font-size: 20px;
					padding: 2px 10px;
					
					padding-bottom: 20px;
			}
			input[type=text],input[type=password]{
					  width: 200px;
					  padding: 3px 10px;
					  margin: 8px 0;
					  box-sizing: border-box;
					  font-family: Segoe UI;
					  font-size: 15px;
					  
			}
			
			input[type=button], input[type=submit], input[type=reset] {
					  background-color: #197278;
					  border: none;
					  color: #EDDDD4;
					  padding: 3px 30px;
					  text-decoration: none;
					  margin: 4px 2px;
					  cursor: pointer;
					  font-family: Segoe UI;
					  font-size: 20px;
					  
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

		<h1>Adminstrator Login</h1><br/>
		<hr class="new5">
	
	
	<div style="margin-top: 8%">
	<form action="login" method="post" >
		<span id="span1">
				User Name <br/>
				
				<input type="text" name="username" placeholder="Enter username" value="yousif"><br/>
				
				Password <br/>
				
				<input type="password" name="password" placeholder="Enter password" value="1234"><br/>
				
				<%  
			
					if(request.getAttribute("TheState") == (Object)false ) {
						
						%><span id="e" style='color:#EDDDD4; text-shadow: 2px 2px #000000;'>Invalid Credentials!!</span><%
					}
				
				%>
				
		</span>
		<div style="text-align: center; margin-top: -13px">
				<input type="submit" value="Login">
		</div>
	
	
	</form>
	</div>
	<div id="myinfo"> 
			@ Developed By: Yousif Al-Dhfeery <br/>
			@ GitHub: https://github.com/xxmelar-ksaxx
	
	</div>


</body>
</html>