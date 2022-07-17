<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		<link rel="stylesheet" href="css.css">
        <link rel="stylesheet" href="DBcss.css">
        
</head>
<body>

	<!-- <h1>List/Add Subject</h1>
	<h2>
	 <a href="MainPage.jsp">Home Page</a>
	 </h2> -->
	    <div style="text-align: center;" >
        <h1 class="pageName">List/Add Subject</h1>
        <br/>
        <hr id="topHederLine">
    	<br/>
    

    <button class="mnueOptions" onclick="window.location.href='MainPage.jsp'" style="width:8em">Home Page</button>
	
	
	<form action="insert" method="post" >
		
		<span class="formSpan" style="margin-top:3%">
		Subject Name: <input type="text" name="subject_input"><br/>
		Subject Credits: <input type="number" name="credits_input"><br/><br/>
		 <%  
	
			if(request.getAttribute("TheState") == (Object)false ) {
				
				%><span id="e" style='color:red'>Empty fields!!</span><%
			}
		
	
		%>
		</span>
		<br/>
		<!-- <input type="Submit" value="Save" style="margin-left: 10%"> -->
		<div style="text-align: center; margin-top: -13px">
            <button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
        </div>
		
		
	</form>
	 </div>
	<br/>
	<br/>
	

	
	
	
	<div align="center">
        <form action="list" >
		<button class="mnueOptions" type="submit" style="width: 6em;">Refresh</button>
	  </form>
        <table border="1" cellpadding="10">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Credits</th>
   
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.credits}" /></td>
                    
                    <td>
                     
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
	
	

</body>
</html>
