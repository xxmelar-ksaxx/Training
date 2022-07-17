<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		
		<script  src="Registrer_javaScripts.js"></script>
		
 
</head>
<body>

	<div style="text-align: center;">
		
			<h2>Login</h2>
			
			
			<form id="RgisterForm" action="register_newUser">
			
			<p id="fields_error"></p>
			<br>
			<input type="text" placeholder="Username" id="n" name="username">
			<input type="email" placeholder="E-Mail" id="e"  name="email">
			<input type="password" placeholder="Password" id="p" name="password">
			
			</form>
			<button onclick="registernew()" >Register</button>
			
	</div>
		
		
		<script >
		
		
		 	window.onload = function () {  // create a form
		 		
			 		var atr = '${email_state}';
			 		if(atr==1){
				 		document.getElementById("fields_error").innerHTML =" Email exsist !!. try agin   from state="+atr;
				 		atr=0;
		 			}
			 		else{
			 			document.getElementById("fields_error").innerHTML ="";	
			 		}
			 		
        	}
		
			function registernew() {
					
					var n=document.getElementById("n").value;
					var e=document.getElementById("e").value;
					var p=document.getElementById("p").value;
					
					if(n==null ||n=="" || e==null ||e=="" || p==null ||p==""){
						document.getElementById("fields_error").innerHTML =" All fields are required !!. try agin";
					}
					else{
						
						document.getElementById("fields_error").innerHTML ="in else";	
					
					 	var xmlHttp = new XMLHttpRequest();
					    xmlHttp.open( "GET", "register_newUser?username="+n+"&email="+e+"&password="+p, false ); // false for synchronous request
					   
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
					
		        	document.forms["RgisterForm"].submit();
		        
		        }
		
		
		</script>
		


</body>
</html>