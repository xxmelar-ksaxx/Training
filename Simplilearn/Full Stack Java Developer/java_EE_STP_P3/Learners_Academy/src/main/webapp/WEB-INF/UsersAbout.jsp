<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	
	<style type="text/css">
		body {
			background-color: #540B0E;
		}
		
		.mnueOptions:hover, .mnueOptions:active {
			background-color: #14868E;
			color: #EDDDD4;
		}
		
		button.mnueOptions {
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
		
		input[type=text], input[type=password], input[type=number], input[type=email]
			{
			width: 200px;
			padding: 3px 10px;
			margin: 8px 0;
			box-sizing: border-box;
			font-family: Segoe UI;
			font-size: 15px;
		}
		
		select {
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
		
		.formSpan {
			display: inline-block;
			text-align: left;
			color: #EDDDD4;
			font-family: Segoe UI;
			font-size: 20px;
			padding: 2px 10px;
			padding-bottom: 20px;
		}
		
		h1.pageName {
			text-align: center;
			color: #EDDDD4;
			font-family: Segoe UI;
			font-size: 40px;
		}
		
		hr#topHederLine {
			margin-top: -30px;
			margin-left: 20%;
			margin-right: 20%;
			border: 1px solid #EDDDD4;
			border-radius: 10px;
		}
		
		#myinfo {
			text-align: left;
			color: #EDDDD4;
			font-family: Segoe UI;
			font-size: 20px;
		}
		
		footer {
			text-align: center;
			clear: both;
			position: relative;
			margin-top: -0px;
			padding-top: 10%;
			font-size: 20px;
			color: #EDDDD4;
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

.AboutPragraph{
	font-size:2vw;
    color:#EDDDD4;
}
		
	</style>
	<script type="text/javascript">
	
	function loadDoc() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("demo").innerHTML = this.responseText; 
		    }
		  };
		  xhttp.open("GET", "Validate_Login2", true);
		  xhttp.send();
		}
	
		
	</script>	
	
</head>
<body >
	
	<div class="navDiv">
		<div class="navlogoDiv">
			<label class="navP">Lerners Academy</label>
		</div>
		<div class="navButtonsDiv">
			<span class="navspanBut">
				<button class="mnueOptions" style="width: 8vw;" onclick="window.location.href='Login.jsp'" style="width: 8em;">Logout</button>
			</span>
			<span class="navspanBut">
				<button class="mnueOptions" style="width: 8vw;" onclick="window.location.href='MainPage'" style="width: 8em;">Home</button>
			</span>
		</div>
	</div>
	
	<h1 class="pageName">About</h1>
	<br />
	<hr id="topHederLine">
	
	<div style="margin-top: 8%; text-align: center;">
	
	<p class="AboutPragraph">Learners academy administration website is a management system to add and alcoate subjects to<br> 
	 classes, also it provides the ability to add teaches and students and assign them to classes. Additionally,<br>
	  the system provides classes information, such as the class subject, room No, teacher name and count of students.<br>
	Note that the website intent is to show the possibility of applying automation on the curses allocation,<br>
	 that to make the management process easier. There for you can observe that some features are not <br>
	 included in the system, like editing the data.</p>
	
	</div>
	

	
	

	<footer>Yousif Salman Al-Dhfeery -- 2180000644 &copy;</footer>
	
	
</body>
</html>