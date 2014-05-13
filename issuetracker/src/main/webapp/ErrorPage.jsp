<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=Constants.WELCOM_PAGE_TITLE %></title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userMenu.jsp"></jsp:include>
		<div class="error-message">
			<h3>Application error:</h3>
			<p>${error}</p>
		</div>
	</div>
</body>
</html>