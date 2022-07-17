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
            <h1 class="pageName">Class informations</h1>
            <br/>
            <hr id="topHederLine">
        <br/>
        <button class="mnueOptions" onclick="window.location.href='MainPage.jsp'" style="width:8em">Home Page</button>
			
		<form action="class_info_refrech">
		<span class="formSpan">
			Class Number:<br/>
				 <select id="Class" name="class_inf_id">
				   			<c:if test="${lci !=  null}">
							<c:forEach var="user" items="${lci}">
							
							<option value="${user[0]}"><c:out value="${user[1]} / RoomNo: ${user[2]}" /></option>
							 
							</c:forEach>
							</c:if>
				 </select>
				 </span>
				<div style="text-align: center; margin-top: -13px">
                	<button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
            	</div>
		</form>
		</div>

<div align="center">
        
        <table border="1" cellpadding="10">
            <caption><h2>Class information</h2></caption>
            <tr>
                <th>Subject</th>
                <th>Room No.</th>
                <th>Teacher</th>
                <th>No of Students</th>
                
                
   
            </tr>
            <c:forEach var="user" items="${class_info}">
                <tr>
                    <td><c:out value="${user[0]}" /></td>
                    <td><c:out value="${user[1]}" /></td>
                    <td><c:out value="${user[2]}" /></td>
                    <td><c:out value="${user[3]}" /></td>
                
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>