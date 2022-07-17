<%@page import="java.util.List"%>
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
        	<style type="text/css">
		body{
    background-color: #540B0E;
}

.mnueOptions:hover, .mnueOptions:active {
  background-color: #14868E;
  color: #EDDDD4;
  }

button.mnueOptions{
        background-color: #197278;
        color: #EDDDD4;

        padding: 7px 1px;
        text-align: center;
        text-decoration: none;
        display: inline-block;

        cursor: pointer;
        font-family: Segoe UI;
        font-size: 20px;

        margin: 0.4% 30% 0.4% 30%;

        width: 17em;
}

input[type=text],input[type=password],input[type=number],input[type=email]{
  width: 200px;
  padding: 3px 10px;
  margin: 8px 0;
  box-sizing: border-box;
  font-family: Segoe UI;
  font-size: 15px;
  
}
select{
  width: 200px;
  padding: 3px 10px;
  margin: 8px 0;
  box-sizing: border-box;
  font-family: Segoe UI;
  font-size: 15px;
}

input[type=button], input[type=submit], input[type=reset] {
  background-color: #197278;
  border: none;
  color: #EDDDD4;
  padding: 3px 30px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  font-family: Segoe UI;
  font-size: 20px;
  
}
.formSpan{
  display: inline-block;
  text-align:   left;
  color: #EDDDD4;
  font-family: Segoe UI;
  font-size: 20px;
  padding: 2px 10px;
  
  padding-bottom: 20px;
}

h1.pageName{
text-align: center; color: #EDDDD4;
font-family: Segoe UI;
font-size: 40px;

}
hr#topHederLine{
  margin-top: -30px;
  margin-left: 20%;
  margin-right: 20%;
  border: 1px solid #EDDDD4;
  border-radius: 10px;
}
#myinfo{
text-align: left; 
color: #EDDDD4;
font-family: Segoe UI;
font-size: 20px;

}

footer{
  text-align: center;
  clear: both;
  position: relative;
  
  margin-top: -0px;
  padding-top: 10%;

  font-size: 20px;
  color: #EDDDD4;
}
		
		table {
    border-collapse: collapse;
    width: 50%;
    font-size:20px;
  }
  
  th, td {
    text-align: left;
    padding: 8px;
    background-color: #ecc9c9;
  }
  
  tr:nth-child(even) {
    background-color: #f06e6e;
}

h2{
    font-size: 40px;
    color: rgb(255, 232, 232);
}

	
	.navDiv{
    background-color: rgb(66, 2, 2);
    /* background-color: rgb(241, 192, 192); */
    min-height: 8vw;
    /* width: fit-content; */
    border: 1px solid #EDDDD4;
    border-radius:11px;
    border-width: 2px;
    padding-left: 1%;
    padding-right: 1%;
}
.navlogoDiv{
    /* background-color:blueviolet; */
    width: 48%;
    height: 100px;
    /* width: fit-content; */
    float: left;
}

.navP{
    font-size:6vw;
    color:#EDDDD4;
}
.navButtonsDiv{
    /* background-color:rgb(88, 8, 163); */
    width: 48%;
    height: 100px;    
    float: right;
    margin-right: 2%;
    display: inline-block;
    padding-right: 1%;
    
}
.navspanBut{    
    /* background-color:rgb(148, 148, 148); */
    float: right;
    margin-right: 2%;
    margin-top: 4vw;
}
	
		
	</style>
</head>
<body>

	  	<div class="navDiv">
		<div class="navlogoDiv">
			<label class="navP">Lerners Academy</label>
		</div>
		<div class="navButtonsDiv">
			<span class="navspanBut">
				<button class="mnueOptions" style="width: 8vw;" onclick="window.location.href='Login.jsp'" style="width: 8em;">Logout</button>
			</span>
			<span class="navspanBut">
				<button class="mnueOptions" style="width: 8vw;" onclick="window.location.href='UsersAbout'" style="width: 8em;">About</button>
			</span>
			<span class="navspanBut">
				<button class="mnueOptions" style="width: 8vw;" onclick="window.location.href='MainPage'" style="width: 8em;">Home</button>
			</span>
		</div>
	</div>
	 
	 	 <div style="text-align: center;">
            <h1 class="pageName">List/Add Student</h1>
            <br/>
            <hr id="topHederLine">
      
      
<form action="StudentSave" method="post">
	<span class="formSpan">
			Name:<br/>	<input type="text" name="name" placeholder="inter name" required="required">
		  	<br/>
		  	Email:<br/> <input type="email" name="email" placeholder="inter email" title="Example: someone@email.co" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})$" required="required">
		  	<br/>
		  	Gender:
		  	<br/>
			  	<select name="jender" required="required">
				    <option value="male">male</option>
				    <option value="female">female</option>
			  	</select>
		 	<br/>
		 	Age:<br/>	<input type="text" name="age" placeholder="age" required="required"><br/>
		  
		  	Class Number:<br/>
				 <select id="Class" name="class1" required="required">
								<%
							if(request.getAttribute("ClassesList") != null ) {
								List<Object[]> p=(List<Object[]>)request.getAttribute("ClassesList");
								for(Object[] o : p){
									%>
									<option value=<%=o[0]%>><%=o[1]%> / RoomNo: <%=o[2]%></option>
									<%		
								}
							}
							%>
				 </select>
		  	<br/>
		  
	  </span><br/>
		<br/>
	 <div style="text-align: center; margin-top: -13px">
                <button class="mnueOptions" type="submit" style="width: 6em;">Save</button>
            </div>
  </form>
  </div>
  		<div align="center">
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
                 <%
            		List<Object[]> p=(List<Object[]>)request.getAttribute("StudentsList");
            	try{
            	for(Object[] o : p){
            		%>
            		<tr>
                    <td><%=o[0]%></td>
                    <td><%=o[1]%></td>
                    <td><%=o[2]%></td>
                    <td><%=o[3]%></td>
                    <td><%=o[4]%></td>
                    <td><%=o[5]%></td>
                    <td><%=o[6]%></td>
                    <td>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="deleteStudent?id=<%=o[0]%>">Delete</a>                     
                    </td>
                </tr>
                <%
				}
            	}catch (Exception e){
            	}
            %>
            
        </table>
    </div>
<footer>Yousif Salman Al-Dhfeery -- 2180000644 &copy;</footer>
</body>
</html>