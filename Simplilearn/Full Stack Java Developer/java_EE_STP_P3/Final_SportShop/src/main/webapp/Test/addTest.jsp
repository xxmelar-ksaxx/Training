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
				<h1>Test MVC </h1>
		</div>
				<br><br><br>	
		
		<form action="addnew">
		<div style="text-align: center;">
				<input type="text" name="t1" placeholder="Value 1"><br>
				<input type="text" name="t2" placeholder="Value 2"><br>
				<input type="text" name="t3" placeholder="Value 3"><br>
				<input type="submit" value="Submit"><br>
		</div>
		</form>


</body>
</html>