<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Issue Tracker</title>
	</head>
	<body>
		<h1>${types}</h1>
		
		<c:forEach var="type" items="${types}">
			<h3>${type}</h3>
		</c:forEach>
		
	</body>
</html>