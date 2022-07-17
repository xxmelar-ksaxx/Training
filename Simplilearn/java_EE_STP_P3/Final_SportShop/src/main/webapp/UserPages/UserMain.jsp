<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div style="text-align: center;"> 
			<h2>Sporty Shoes Store</h2>
			<input type="button" value="Cart">
		</div>
		<br>
		<p>result is= ${login_result}</p>
		
		<div style="text-align: center;">
			
			 <c:forEach var = "i" begin = "1" end = "5">
        	
     		     <span style="background-color: #a63b48">
        		 Item <c:out value = "${i}"/><p>
     		     
     		     </span>
     		
     		 </c:forEach>
			
		</div>
		


</body>
</html>