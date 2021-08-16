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
	<h1>New Category</h1>
	
		<form:form action="/new/category" method="post" modelAttribute="category">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
		
	
</body>
</html>