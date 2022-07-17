<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

			<style type="text/css">
			
						
						body{
						background-color: #540B0E;
						}
						h1{
							text-align: center; color: #EDDDD4;
							font-family: Segoe UI;
							font-size: 40px;
					
						}
						hr.new5 {
							  margin-top: -30px;
							  margin-left: 20%;
							  margin-right: 20%;
							  border: 1px solid #EDDDD4;
							  border-radius: 10px;
						}
						form{
								text-align: center;
						}
						#span1{
								display: inline-block;
								text-align:   left;
								color: #EDDDD4;
								font-family: Segoe UI;
								font-size: 20px;
								padding: 2px 10px;
								
								padding-bottom: 20px;
						}
						input[type=text],input[type=password]{
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
						
						table{
							 	text-align: center; color: #EDDDD4;
								font-family: Segoe UI;
								font-size: 20px;
							 	
							 	border: 1px solid #EDDDD4;
							  	border-radius: 10px;
						}
						
			
			
			</style>

</head>
<body>

			<h1>Product information</h1>
			<hr class="new5">
	
			
		<form action="insert" class="form" >
				<span id="span1">
				 <%
				 
				 String x="";
				 String y="";
				 String z="";
				 String state=(String)request.getAttribute("TheState");
				 String state_2=(String)request.getAttribute("TheState_2");
				 if(state==null){
				 }
				 else if( state.equals("")){
				 }
				 else{
					 x=(String)request.getAttribute("name");
					 y=(String)request.getAttribute("price");
					 z=(String)request.getAttribute("id");
				 }
				 %>
				 Product ID
				 <input type="text" placeholder="Product ID" name="product_id" value="<%=z%>" ><br/>
				 Product Name
				 <input type="text" placeholder="Product Name" name="product_name" value="<%=x%>" ><br/>
				 Product Price
				 <input type="text" placeholder="Product Price" name="product_price" value="<%=y%>" ><br/>
				 <%
				 if(state_2==null){
					 
				 }
				 else if( state_2.equals("number")){
					 %>Price take only numbers!! <%
				 }
				 else if( state_2.equals("missing")){
					 %>Missing fields !!<%
				 }
				 
				 
				 %>
				</span>
				<br/>
				<input  type="submit" value="Save">
		</form>

<div align="center">
        
        <table border="1" cellpadding="10">
            <caption><h2>Product information</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
        
         
            </tr>
           
                <tr>
                    <td><%=z%></td>
                    <td><%=x%></td>
                    <td><%=y%></td>
                 
                </tr>
       
        </table>
    </div>

</body>
</html>