<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			<c:when test="${f:length(issues) == 0 }">
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
							<td class="id-tab"><c:choose>
									<c:when test="${user == null }">
										<c:set var="idLink" value="#"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="idLink" value="#"></c:set>
									</c:otherwise>
								</c:choose> <a href="${idLink }">${issue.id }</a></td>
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
							<td><c:if test="${issue.assignee != null }">
										${issue.assignee.firstName}
										${issue.assignee.lastName}
									</c:if></td>
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