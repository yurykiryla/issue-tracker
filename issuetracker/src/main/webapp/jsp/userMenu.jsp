<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/styles.css">
</head>
<body>
	<div class="user-auth">
		<c:choose>
			<c:when test="${user == null }">
				<form name="loginForm" action=<%=Constants.LOGIN_FORM_ACTION%> method="post" class="login-form">
					<label for="login">E-mail</label> 
					<input type="text" name=<%=Constants.KEY_EMAIL%> id="login" required class="input-login">
					<label for="password">Password</label> 
					<input type="password" name=<%=Constants.KEY_PASSWORD%> id="password" required class="input-password">
					<input type="submit" value="Login" class="login-button">
				</form>
			</c:when>
			<c:otherwise>
				<div class="user-welcome">
					Welcome
					<ul class="menu">
						<li><span class="user-welcome-name"><c:out value="${user.firstName }"></c:out></span>
							<ul>
								<li><a href="#">Change preferences</a></li>
								<li><a href="#">Change password</a></li>
								<li><a href=<%=Constants.URL_LOGOUT%>>Logout</a></li>
							</ul></li>
					</ul>
				</div>
				<c:if test="${user.role == 'ADMINISTRATOR' }">
					<div class="administrator-menu">
						<ul class="menu">
							<li><span class="administrator-menu-name">Administrator menu</span>
								<ul>
									<li><a href="#">Projects</a></li>
									<li><a href="#">Statuses</a></li>
									<li><a href="#">Resolutions</a></li>
									<li><a href="#">Priorities</a></li>
									<li class="br"><a href="#">Types</a></li>
									<li><a href="#">Add Project</a></li>
									<li><a href="#">Add Resolution</a></li>
									<li><a href="#">Add Priority</a></li>
									<li class="br"><a href="#">Add Type</a></li>
									<li><a href="#">Search user</a></li>
									<li><a href="#">Add new user</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</c:if>
				<div class="submit-issue-block">
					<button class="submit-issue-button" 
							onclick="location.href='jsp/SubmitIssuePage.jsp'">
						Submit Issue
					</button>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="search-block">
			<button class="search-button">Search</button>
		</div>
	</div>
</body>
</html>