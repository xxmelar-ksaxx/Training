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
				<h1>Add new product</h1>
		</div>
					<br><br><br>
		
						
				
						<form action="Admin_addNew" method="get">
								<div style="text-align: center;">
									
									
									
									Product name:
									<input type="text" placeholder="Product Name" name="product_name"  /><br>
									Product price:
									<input type="text" placeholder="Product Price" name="product_price" /><br>
									Product category:
									<select name="product_category"   >
										  <option value="volvo">Volvo</option>
										  <option value="saab">Saab</option>
										  <option value="mercedes">Mercedes</option>
										  <option value="audi">Audi</option>
									</select> <br>
									
									Product image:
									<input type="file" placeholder="Product image" name="product_image"  value="Image path"/><br>
									
									<input type="submit" value="Submit" >
								</div>
					
								
				
						</form>
			
	
		
				<br><br><br>
				
				<img alt=" image not found !! " src="data:image/png;base64,${img_result}">
				
				
		<form action="RefreshProductsList">
				<input type="submit" value="Refresh List">
				<div style="text-align: center;">
						
						
						<table style="border: 1px solid;">
						
						<tr>
			                <th>name</th>
			                <th>price</th>
			                <th>category</th>
			                <th>image</th>
			   
			            </tr>
						<c:forEach var = "i" items="${ListOfProducts}">
        					
        					<tr style="border: 1px solid;">
				     		     
				     		     <td style="border: 1px solid;"><c:out value = "${i[1]}"/><p></td>
				     		     <td style="border: 1px solid;"><c:out value = "${i[2]}"/><p></td>
				     		     <td style="border: 1px solid;"><c:out value = "${i[3]}"/><p></td>
				     		     <td style="border: 1px solid;"><img alt=" image not found !! " src="data:image/png;base64,${i[4]}" width="250" height="120"> </td>

								<td> &nbsp;&nbsp;&nbsp;&nbsp;
			                     		<a href="EditProduct?id=<c:out value='${i[0]}' />&name=${i[1]}&price=${i[2]}&image=${i[4]}&catigory=${i[3]}">Edit</a>                     
			                    </td>
								<td> &nbsp;&nbsp;&nbsp;&nbsp;
			                     		<a href="DeleteProduct?id=<c:out value='${i[0]}' />">Delete</a>                     
			                    </td>
				

        					</tr>
        					
	     			 	</c:forEach>
						
						</table>
				</div>
		
		</form>
		
		
		
		
</body>
</html>