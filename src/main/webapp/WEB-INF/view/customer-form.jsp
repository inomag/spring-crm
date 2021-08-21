<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
	<link type ="text/css"
			rel = "stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/add-customer.css">
</head>
<body>
	<div id="container">
	
		<h2>CRM - Customer Relationship Manager</h2>
		
		<form:form action="save" modelAttribute="customer" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName"/></td>			
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName"/></td>			
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email"/></td>			
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" value="Save Customer" class="save"/></td>			
					</tr>
				
				
				</tbody>
			
			
			</table>
		
		</form:form>
		
		<div style="clear;both;"></div>
		
		<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
	
	
	</div>


	
	

</body>
</html>