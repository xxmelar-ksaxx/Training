<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List/Add Teachers</title>

        <link rel="stylesheet" href="css.css">
        <link rel="stylesheet" href="DBcss.css">
</head>
<body>

	
		<div style="text-align: center;">
            <h1 class="pageName">List/Add Teachers</h1>
            <br/>
            <hr id="topHederLine">
        <br/>
        <button class="mnueOptions" onclick="window.location.href='MainPage.jsp'" style="width:8em">Home Page</button>
		
		<form action="insert_teacher">
		<span class="formSpan">
				Name:<br/><input type="text" name="name" placeholder="inter name">
			  	<br/>
			  	Email:<br/> <input type="email" name="email" placeholder="inter email">
			  	<br/>
			  	Gender:
				<br/>
					<select name="gender">
					    <option value="male">male</option>
					    <option value="female">female</option>
					 </select>
			 	<br/>
			 	Age:
			 	<br/>
			  		<input type="text" name="age" placeholder="age">
			  	<br/>
			 	Role:
			 	<br/>
			 		
				 	<select name="role">
					    <option value="Teacher">Teacher</option>
				  </select>
		 </span><br/>
	  
	  		 <%  
	
				if(request.getAttribute("TheState") == (Object)false ) {
					
					%><span id="e" style='color:red'>Empty fields!!</span><%
				}
		
	
			%>
	  		 <div style="text-align: center; margin-top: -13px">
                <button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
            </div>
	  
	  </form>
		</div>
		<div align="center">
        <form action="list_teacher" >
				<button class="mnueOptions" type="submit" style="width: 6em;">Refresh</button>
	  </form>
        <table border="1" cellpadding="10">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Role</th>
                
   
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.jender}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    
                    <td>
                     
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete_teacher?id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
		

</body>
</html>