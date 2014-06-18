<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controller.Constants"%>
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
				<td class="view-issue-header"><label>Id</label></td>
				<td class="view-issue-value">${issue.id}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Create Date</label></td>
				<td class="view-issue-value">${issue.createDate}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Created By</label></td>
				<td class="view-issue-value">${issue.createdBy}</td>
			</tr>
			<c:if test="${issue.modifyDate != null }">
				<tr>
					<td class="view-issue-header"><label>Modify Date</label></td>
					<td class="view-issue-value">${issue.modifyDate}</td>
				</tr>
			</c:if>
			<c:if test="${issue.modifiedBy != null }">
				<tr>
					<td class="view-issue-header"><label>Modified By</label></td>
					<td class="view-issue-value">${issue.modifiedBy}</td>
				</tr>
			</c:if>
			<tr>
				<td class="view-issue-header"><label>Summary</label></td>
				<td class="view-issue-value">${issue.summary}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Description</label></td>
				<td class="view-issue-value">${issue.description}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Status</label></td>
				<td class="view-issue-value">${issue.status}</td>
			</tr>
			<c:if test="${issue.resolution != null }">
				<tr>
					<td class="view-issue-header"><label>Resolution</label></td>
					<td class="view-issue-value">${issue.resolution}</td>
				</tr>
			</c:if>
			<tr>
				<td class="view-issue-header"><label>Type</label></td>
				<td class="view-issue-value">${issue.type}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Priority</label></td>
				<td class="view-issue-value">${issue.priority}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Project</label></td>
				<td class="view-issue-value">${issue.project}</td>
			</tr>
			<tr>
				<td class="view-issue-header"><label>Build found</label></td>
				<td class="view-issue-value">${issue.buildFound}</td>
			</tr>
			<c:if test="${issue.assignee != null }">
				<tr>
					<td class="view-issue-header"><label>Assignee</label></td>
					<td class="view-issue-value">${issue.assignee}</td>
				</tr>
			</c:if>
		</table>
		<button onclick="history.back()" class="back-button">Back</button>
	</div>
</body>
</html>
