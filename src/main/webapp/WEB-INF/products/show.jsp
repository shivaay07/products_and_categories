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
	<h1>${singleProd.name}</h1>
	
	<c:forEach items= "${singleProd.categories}" var="sP">
		<li><c:out value="${sP.name}"/></li>
	</c:forEach>
	<form action="/add/category/${singleProd.id}" method="post">
		<label>Add Category:</label>
		<select name="addedCategory">
			<option value="" disabled selected></option>
				<c:forEach items="${prodWithCat}" var="pC">
					<option value="${pC.id}"><c:out value="${pC.name}"/></option>
				</c:forEach>
			
		</select>
		<input type="submit" value="Add"/>
	</form>
	<a href="/products/new">New Products</a><a href="/categories/new">New Categories</a>
	

</body>
</html>