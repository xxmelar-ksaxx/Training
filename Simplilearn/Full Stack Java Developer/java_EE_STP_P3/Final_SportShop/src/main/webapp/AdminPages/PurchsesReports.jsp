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
				<h1>Purchases Reports</h1>
		</div>
					<br><br><br>

		<form action="PurchasesReportsList">
		
				<div style="text-align: center;">
					
					<input type="submit" value="Refresh"><br><br><br>
					
					<div style="text-align: center;">
						
						<c:forEach var = "i" begin = "1" end = "5">
        	
				     		     <span >
				        		 Item <c:out value = "${i}"/><p>
				     		     
				     		     </span>
				     		
	     			 	</c:forEach>
						
					</div>
					
					
					
					
				</div>
		
		</form>


</body>
</html>