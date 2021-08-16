<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Product</h1>
	
		<form:form action="/new/product" method="post" modelAttribute="product">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:textarea path="description"/>
			</p>
			<p>
				<form:label path="price">Price:</form:label>
				<form:errors path="price"/>
				<form:input type ="number" path="price"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
		
</body>
</html>