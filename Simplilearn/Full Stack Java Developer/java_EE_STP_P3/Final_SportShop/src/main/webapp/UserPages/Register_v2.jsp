<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		
		
		
 
</head>
 <body style="text-align: center;">
        <h1 style="color: green;">
            GeeksforGeeks
        </h1>
        <p>
              Click on the button to create 
            a form dynamically
        </p>
       
       
        <p id="GFG_DOWN"></p>
        
        <br><br><br>
        
        
        <button  onclick="submit()">Submit @</button>
        <br><br><br>
        
        <form id="loginForm" action="destination.html">
		  <input type="text" value="Hello there">
		  <input type="submit" value="Go" id="submitInput">
		</form>
		<div id="other">
		  Trigger the handler
		</div>
        
           
        <script>
            
        
        var down = document.getElementById("GFG_DOWN");
        window.onload = function () {  // create a form
        	GFG_Fun()
        	
        	}
        
        var s;
      
        function submit() {
			
        	document.forms["loginForm"].submit();
        
        }
        
            function GFG_Fun() {
                
                // Create a form synamically
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "submit.php");
  
                // Create an input element for emailID
                var N = document.createElement("input");
                N.setAttribute("type", "text");
                N.setAttribute("name", "name");
                N.setAttribute("placeholder", "Name");
                
                // Create an input element for emailID
                var E = document.createElement("input");
                E.setAttribute("type", "email");
                E.setAttribute("name", "emailID");
                E.setAttribute("placeholder", "E-Mail ID");
  
                // Create an input element for password
                var PWD = document.createElement("input");
                PWD.setAttribute("type", "password");
                PWD.setAttribute("name", "password");
                PWD.setAttribute("placeholder", "Password");
  
                // Create a submit button
                s = document.createElement("input");
                s.setAttribute("type", "submit");
                s.setAttribute("value", "Submit");
               	
  
             	// Append the Name input to the form
                form.append(N); 
                
                // Append the email_ID input to the form
                form.append(E); 
                
                // Append the password to the form
                form.append(PWD); 
                
                // Append the button to the form
                form.append(s); 
  
                document.getElementsByTagName("body")[0]
               .appendChild(form);
            }
            
            
            
        </script>
    </body>
</html>