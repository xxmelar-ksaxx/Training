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

	
	 
	 	 <div style="text-align: center;">
            <h1 class="pageName">List/Add Student</h1>
            <br/>
            <hr id="topHederLine">
        <br/>
        <button class="mnueOptions" onclick="window.location.href='MainPage.jsp'" style="width:8em">Home Page</button>
	 
<form action="insert_student">
	<span class="formSpan">
			Name:<br/>	<input type="text" name="name" placeholder="inter name">
		  	<br/>
		  	Email:<br/> <input type="email" name="email" placeholder="inter email">
		  	<br/>
		  	Gender:
		  	<br/>
			  	<select name="jender">
				    <option value="male">male</option>
				    <option value="female">female</option>
			  	</select>
		 	<br/>
		 	Age:<br/>	<input type="text" name="age" placeholder="age"><br/>
		  
		  	Class Number:<br/>
				 <select id="Class" name="class1">
				   			<c:if test="${listclasses !=  null}">
							<c:forEach var="user" items="${listclasses}">
							
							<option value="${user[0]}"><c:out value="${user[1]} / RoomNo: ${user[2]}" /></option>
							 
							</c:forEach>
							</c:if>
				 </select>
		  	<br/>
		  	Role:<br/>
			  	<select name="role">
				    <option value="Student">Studnt</option>
			 	</select>
	  </span><br/>
	   <%  
	
			if(request.getAttribute("TheState") == (Object)false ) {
				
				%><span id="e" style='color:red'>Empty fields!!</span><%
			}
		
	
		%>
		<br/>
	 <div style="text-align: center; margin-top: -13px">
                <button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
            </div>
  </form>
  </div>
  
  		<div align="center">
        <form action="list_student" >
		<button class="mnueOptions" type="submit" style="width: 6em;">Refresh</button>
	  </form>
        <table border="1" cellpadding="10">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Role</th>
                <th>Class</th>
                
   
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user[0]}" /></td>
                    <td><c:out value="${user[1]}" /></td>
                    <td><c:out value="${user[2]}" /></td>
                    <td><c:out value="${user[3]}" /></td>
                    <td><c:out value="${user[4]}" /></td>
                    <td><c:out value="${user[5]}" /></td>
                    <td><c:out value="${user[6]}" /></td>
                    
                    <td>
                    
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete_student?id=<c:out value='${user[0]}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>