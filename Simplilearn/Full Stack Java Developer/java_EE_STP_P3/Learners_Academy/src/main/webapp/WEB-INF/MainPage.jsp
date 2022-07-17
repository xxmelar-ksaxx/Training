<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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

<script type="text/javascript">
	
	function loadDoc(Page) {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	 
		    }
		  };
		  xhttp.open("GET", Page, true);
		  xhttp.send();
		}
	</script>

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
			
		</div>
	</div>


	<div style="text-align: center;">
			<h1 class="pageName">Main Menu</h1>   
            <br/>
			<hr id="topHederLine">
		<br/>
		
		<button class="mnueOptions" onclick="window.location.href='Subjects'">List/Add Subject</button>
		<button class="mnueOptions" onclick="window.location.href='Classes'">List/Add Classes</button>
		<button class="mnueOptions" onclick="window.location.href='Teachers'">List/Add Teachers</button>
		<button class="mnueOptions" onclick="window.location.href='TC'">List/Assign The Teachers Classes</button>
		<button class="mnueOptions" onclick="window.location.href='Students'">List/Add Student</button>
		<button class="mnueOptions" onclick="window.location.href='Classes_Info'">Class information</button>

	<footer>Yousif Salman Al-Dhfeery -- 2180000644 &copy;</footer>


</body>
</html>