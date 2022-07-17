<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Hello from HTML</h1>
	<%= "<h1> Hello from JSP </h1>" %>
	
	<%
	 int x=0;
	
		while(x!=10){
			out.print("i = "+x+" <br/>");
			x++;
		}
	%>

	<input type="text" value="<%= x %>">

		<%-- 
		
		   just a comment
		
		--%>
	
		<form action="">
		
			Enter Name: <input type="text" name="fname" >
			<input type="submit" name="click" value="Click me">
			
		
		</form>
	
		<%
		
		if(request.getParameter("click") !=null){
			out.print("Hello "+ request.getParameter("fname"));
		}
		
		%>
	
	

	<%@ include  file="footer.html" %>



</body>
</html>