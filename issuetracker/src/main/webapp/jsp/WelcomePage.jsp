<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<c:choose>
			<c:when test="${fn:length(issues) == 0 }">
				<div class="empty-issues-list">
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
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>id">Id</a></th>
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>priority">Priority</a></th>
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>assignee">Assignee</a></th>
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>type">Type</a></th>
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>status">Status</a></th>
							<th><a href="<%=Constants.URL_SORT_ISSUES_CONTROLLER%>summary">Summary</a></th>
						</tr>
					</thead>
					<c:forEach items="${issues }" var="issue">
						<tr class="issues-row">
							<td class="id-tab">
								<a href="<%=Constants.URL_CHANGE_ISSUE_CONTROLLER%>${issue.id}">${issue.id }</a></td>
							<c:choose>
								<c:when test="${issue.priority.id == 1 }">
									<c:set var="priorityClass" value="priority-critical"></c:set>
								</c:when>
								<c:when test="${issue.priority.id == 2 }">
									<c:set var="priorityClass" value="priority-important"></c:set>
								</c:when>
								<c:when test="${issue.priority.id == 3 }">
									<c:set var="priorityClass" value="priority-major"></c:set>
								</c:when>
								<c:when test="${issue.priority.id == 4 }">
									<c:set var="priorityClass" value="priority-minor"></c:set>
								</c:when>
							</c:choose>
							<td class="${priorityClass} priority-col">${issue.priority.toString()}</td>
							<td>
							<c:choose>
								<c:when test="${issue.assignee != null}">
									${issue.assignee.firstName}	${issue.assignee.lastName}
								</c:when>
								<c:otherwise>
									Not Assigned
								</c:otherwise>
							</c:choose>
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