<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=Constants.OPERATION_RESULT_PAGE_TITLE %></title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userMenu.jsp"></jsp:include>
		<div class="operation-result-message">
			<h3>Operation result:</h3>
			<p>${message}</p>
			<button onclick="location.href='<%=Constants.URL_WELCOM_PAGE_CONTROLLER_FROM_JSP%>'">Back</button>
		</div>
	</div>
</body>
</html>