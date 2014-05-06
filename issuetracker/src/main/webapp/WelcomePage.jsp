<%@page import="model.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.constants.Constants" %>
<%@page import="model.constants.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<header>
				<img src="images/issue-tracker-name.gif" alt="Logo">
			</header>
			<div class="user-auth">
				<c:choose>
					<c:when test="${user == null }">
						<form name="loginForm" action="/issuetracker/LoginController" method="post" class="login-form">
							<label for="login">E-mail</label>
							<input type="text" name="login" id="login" required class="input-login">
							<label for="password">Password</label>
							<input type="password" name="password" id="password" required class="input-password">
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
										<li><a href="/issuetracker/LogoutController">Logout</a></li>
									</ul>
								</li>
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
							<button class="submit-issue-button">Submit Issue</button>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="search-block">
					<button class="search-button">Search</button>
				</div>
			</div>
			
			<c:choose>
				<c:when test="${f:length(issues) == 0 }">
					<div>
						<c:choose>
							<c:when test="${user == null }">
								Issues list is empty
							</c:when>
							<c:otherwise>
								Not assigned issues
							</c:otherwise>
						</c:choose>
					</div>
				</c:when>
				<c:otherwise>
					<table class="issues-list">
						<thead>
							<tr>
								<th>Id</th>
								<th>Priority</th>
								<th>Assignee</th>
								<th>Type</th>
								<th>Status</th>
								<th>Summary</th>
							</tr>
						</thead>
						<c:forEach items="${issues }" var="issue">
							<tr class="issues-row">
								<td class="id-tab">
									<c:choose>
										<c:when test="${user == null }">
											<c:set var="idLink" value="#"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="idLink" value="#"></c:set>
										</c:otherwise>
									</c:choose>
									<a href="${idLink }">${issue.id }</a>
								</td>
								<c:choose>
									<c:when test="${issue.priority == 'CRITICAL' }">
										<c:set var="priorityClass" value="priority-critical"></c:set>
									</c:when>
									<c:when test="${issue.priority == 'IMPORTANT' }">
										<c:set var="priorityClass" value="priority-important"></c:set>
									</c:when>
									<c:when test="${issue.priority == 'MAJOR' }">
										<c:set var="priorityClass" value="priority-major"></c:set>
									</c:when>
									<c:when test="${issue.priority == 'MINOR' }">
										<c:set var="priorityClass" value="priority-minor"></c:set>
									</c:when>
								</c:choose>
								<td class="${priorityClass} priority-col">${issue.priority.toString()}</td>
								<td>
									${issue.assignee.firstName}
									${issue.assignee.lastName}
								</td>
								<td>${issue.type.toString()}</td>
								<td>${issue.status.toString()}</td>
								<td class="summary-col">${issue.summary}</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
			
			
		</div>
	</body>
</html>