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
		
						
				
						<form  action="Admin_updateProduct" method="get">
								<div style="text-align: center;">
									
									<input type="hidden" name="product_id" value="${setId}" >
									
									Product name:
									<input type="text" placeholder="Product Name" name="product_name" value="${setName}"  /><br>
									Product price:
									<input type="text" placeholder="Product Price" name="product_price" value="${setPrice}" /><br>
									Product category:
									<select name="product_category"  >
										  <option value="volvo">Volvo</option>
										  <option value="saab">Saab</option>
										  <option value="mercedes">Mercedes</option>
										  <option value="audi">Audi</option>
									</select> <br>
									
									Product image:
									<input id="imagePath" type="file" placeholder="Product image" name="product_image"/><br>
									
									<input type="submit" value="Save" />
								</div>
					
								
				
			
	
		
				<br><br><br>
				
				<table>
					<tr>
						<th>Old</th>
						<th>New</th>
					</tr>
					<tr>
						<td><img alt=" No image found" src="data:image/png;base64,${setImage}" width="250" height="120" ></td>
						<td><img id="newImage" alt=" No image found"  width="250" height="120" ></td>
					</tr>
				</table>
						
						</form>
			
						
						<script>
						
						var el = document.getElementById('imagePath');
						el.onchange = function(){
							document.getElementById("newImage").src =  document.getElementById("imagePath").value;
							};
						
						</script>
						
						
			
		<form action="RefreshProductsList">
				<input type="submit" value="Refresh List">
		</form>
		


</body>
</html>