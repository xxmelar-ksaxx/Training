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
            <h1 class="pageName">List/Assign The Teachers Classes</h1>
            <br/>
            <hr id="topHederLine">
        <br/>
        <button class="mnueOptions" onclick="window.location.href='MainPage.jsp'" style="width:8em">Home Page</button>
	 
	 
 	<form action="inserst_TC">
		 <span class="formSpan">
			 <br/>
			 Teacher Name:<br/>
				 <select id="Teacher" name="t_name">
					 		<c:if test="${listteachers !=  null}">
							<c:forEach var="user" items="${listteachers}">
							
							<option value="${user.id}"><c:out value="${user.name}" /></option>
							 
							</c:forEach>
							</c:if>
				 </select>
			 <br/>
			 Class :<br/>
				 <select id="Class" name="c_name">
					  		<c:if test="${listclasses !=  null}">
							<c:forEach var="user" items="${listclasses}">
							
							<option value="${user[0]}"><c:out value="${user[1]} / Room ${user[2]}" /></option>
							 
							</c:forEach>
							</c:if>
				 </select>
		 </span>
		 <br/>
		 <%  
	
			if(request.getAttribute("TheState") == (Object)false ) {
				
				%><span id="e" style='color:red'>Empty selection!!</span><%
			}
		
	
		%>
		  <div style="text-align: center; margin-top: -13px">
                <button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
            </div>
		 
 	</form>
 	</div>
 	
 	<div align="center">
        <form action="list_TC" >
		<button class="mnueOptions" type="submit" style="width: 6em;">Refresh</button>
	  </form>
        <table border="1" cellpadding="15">
            <caption><h2>List of assigned Teachers Classes</h2></caption>
            <tr>
                <th>Teacher</th>
                <th>Subject</th>
                <th>RoomNo</th>
                <th>Time</th>
                
                
   
            </tr>
            <c:forEach var="user" items="${list_tc}">
                <tr>
                    
                    <td><c:out value="${user[1]}" /></td>
                    <td><c:out value="${user[2]}" /></td>
                    <td><c:out value="${user[3]}" /></td>
                    <td><c:out value="${user[4]}" /></td>
                  
                    
                    <td>
                     
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete_tc?id=<c:out value='${user[0]}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>