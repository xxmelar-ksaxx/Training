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
	<p id="fields_error"></p>
	<form id="LoginForm" action="user_login">
		<h2>Login</h2>
		
		<input type="email" placeholder="E-Mail" id="e"  name="email">
		<input type="password" placeholder="Password" id="p" name="password">
		
	</form>
		<button onclick="registernew()">Login</button>
	</div>
	
	<script >
		
		
		 	window.onload = function () {  // create a form
			 		var atr = '${login_state}';
			 		if(atr==1){
				 		document.getElementById("fields_error").innerHTML ="wrong credentials! Try agin. ";
				 		
		 			}
			 		else{
			 			document.getElementById("fields_error").innerHTML ="";	
			 		}
        	}
			function registernew() {
					
					var e=document.getElementById("e").value;
					var p=document.getElementById("p").value;
					if(e==null ||e=="" || p==null ||p==""){
						document.getElementById("fields_error").innerHTML =" All fields are required !!. try agin";
					}
					else{
						document.getElementById("fields_error").innerHTML ="in else";	
					 	var xmlHttp = new XMLHttpRequest();
					    xmlHttp.open( "GET", "register_newUser?email="+e+"&password="+p, false ); // false for synchronous request
					    xmlHttp.setRequestHeader('Content-Type', 'application/json');
					    //xmlHttp.send( null );
					    if(xmlHttp.responseText=="email exsist!"){
					    	document.getElementById("fields_error").innerHTML =" Email exsist !!. try agin";	
					    }
					    else{
					    	submit1();
					    	//window.location.href = xmlHttp.responseText; // send to dispather
					    }
					}
			    }
			function submit1() {
		        	document.forms["LoginForm"].submit();
		        }
		</script>
	

</body>
</html>