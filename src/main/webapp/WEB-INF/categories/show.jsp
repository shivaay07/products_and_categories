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
	<h1>${categoryShowingOnPage.name}</h1>
	<c:forEach items= "${categoryShowingOnPage.products}" var="CatPro">
		<li><c:out value="${CatPro.name}"/></li>
	</c:forEach>
	
	<form action="/create/product/${categoryShowingOnPage.id}" method = "post"> 
		<label>Add Product:</label>
		<select name="addProduct">
		<option value="" disabled selected></option>
			<c:forEach items= "${catWithPro}" var="cP">
				<option value="${cP.id}"><c:out value="${cP.name}"/>"${cP.name}"</option>
			</c:forEach>
		</select>	
		<input type="submit" value="Add"/>
	</form>
	<a href="/products/new">New Products</a><a href="/categories/new">New Categories</a>
</body>
</html>