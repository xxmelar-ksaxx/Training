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
				<h1>List of users</h1>
		</div>
					<br><br><br>
		
		<form action="SearchUser">
			<div style="text-align: center;">
				Enter User ID:
				<input type="text" placeholder="User ID"><br>
				<input type="submit" value="Submit"><br>
			</div>		
		</form>
		
			<br><br><br><br><br><br>
		
		<form action="RefreshUserList">
		
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