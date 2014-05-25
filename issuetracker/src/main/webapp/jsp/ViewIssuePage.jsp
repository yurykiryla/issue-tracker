<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=Constants.SUBMIT_ISSUE_PAGE_TITLE %></title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userMenu.jsp"></jsp:include>
		<table class="view-issue-table">
			<tr>
				<td><label>Id</label></td>
				<td>${issue.id}</td>
			</tr>
			<tr>
				<td><label>Create Date</label></td>
				<td>${issue.createDate}</td>
			</tr>
			<tr>
				<td><label>Created By</label></td>
				<td>${issue.createdBy}</td>
			</tr>
			<c:if test="${issue.modifyDate != null }">
				<tr>
					<td><label>Modify Date</label></td>
					<td>${issue.modifyDate}</td>
				</tr>
			</c:if>
			<c:if test="${issue.modifiedBy != null }">
				<tr>
					<td><label>Modified By</label></td>
					<td>${issue.modifiedBy}</td>
				</tr>
			</c:if>
			<tr>
				<td><label>Summary</label></td>
				<td>${issue.summary}</td>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td>${issue.description}</td>
			</tr>
			<tr>
				<td><label>Status</label></td>
				<td>${issue.status}</td>
			</tr>
			<c:if test="${issue.resolution != null }">
				<tr>
					<td><label>Resolution</label></td>
					<td>${issue.resolution}</td>
				</tr>
			</c:if>
			<tr>
				<td><label>Type</label></td>
				<td>${issue.type}</td>
			</tr>
			<tr>
				<td><label>Priority</label></td>
				<td>${issue.priority}</td>
			</tr>
			<tr>
				<td><label>Project</label></td>
				<td>${issue.project}</td>
			</tr>
			<tr>
				<td><label>Build found</label></td>
				<td>${issue.buildFound}</td>
			</tr>
			<c:if test="${issue.assignee != null }">
				<tr>
					<td><label>Assignee</label></td>
					<td>${issue.assignee}</td>
				</tr>
			</c:if>
		</table>
		<input type="button" value="Back" onclick="history.back()"/>
	</div>
</body>
</html>
