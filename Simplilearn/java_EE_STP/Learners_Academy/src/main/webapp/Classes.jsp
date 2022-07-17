<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add/List Classes</title>
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="DBcss.css">
</head>
<body>

	
 	
 	 	<div style="text-align: center;">
        <h1 class="pageName">List/Add Classes</h1>
        <br/>
        <hr id="topHederLine">
    <br/>
	
	 <form action="insert_class" >
	  	<span class="formSpan" style="margin-top:2%">
		    
				 Subject:<br/>
					<select id="Class" name="subject_name">
							<c:if test="${listSubjects !=  null}">
							<c:forEach var="user" items="${listSubjects}">
							
							<option><c:out value="${user.name}" /></option>
							 
							</c:forEach>
							</c:if>
							
							
					 </select>
				 <br/>
				 Room Number:<br/>
					 <select id="Class" name="room_no">
						   	<option value="01">01</option>
						 	<option value="02">02</option>
						    <option value="03">03</option>
						    <option value="04">04</option>
					 </select>
				<br/>
				Class Time:<br/>
					<select id="Class" name="class_time">
						   	<option >10</option>
							<option >12</option>
						    <option >02</option>
						    <option >04</option>
					 </select> 
	 		
		  <br/>
		   <%  
	
			if(request.getAttribute("TheState") == (Object)false ) {
				
				%><span id="e" style='color:red'>Empty selection!!</span><%
			}
		
	
		%>
		</span>
		  <br/>
		  <div style="text-align: center; margin-top: -13px">
                    <button class="mnueOptions" type="submit" style="width: 6em;">Create</button>
                </div>
 	</form>

	<div align="center">
        <form action="list_classes" >
		 <button class="mnueOptions" type="submit" style="width: 6em;">Refresh</button>
	  </form>
        <table border="1" cellpadding="10">
            <caption><h2>List of Classes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Subject</th>
                <th>RoomNo</th>
                <th>Time</th>
                
                
   
            </tr>
            <c:forEach var="user" items="${listClasses}">
                <tr>
                    <td><c:out value="${user[0]}" /></td>
                    <td><c:out value="${user[1]}" /></td>
                    <td><c:out value="${user[2]}" /></td>
                    <td><c:out value="${user[3]}" /></td>
                  
                    
                    <td>
                     
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete_class?id=<c:out value='${user[0]}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>