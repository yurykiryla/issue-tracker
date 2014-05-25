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
		<form id="submitIssueForm" class="submit-issue" action=<%=Constants.ADD_ISSUE_FORM_ACTION%>>
			<table class="submit-issue-table">
				<tr>
					<td><label id="summaryLabel">Summary</label></td>
					<td><input type="text" name="summary" id="summaryInput" onchange="changeSummary()"/></td>
				</tr>
				<tr>
					<td><label id="descriptionLabel">Description</label></td>
					<td><textarea rows="5" cols="50" name=<%=Constants.KEY_DESCRIPTION%> id="descriptionInput" onchange="changeDescription()"></textarea></td>
				</tr>
				<tr>
					<td><label id="statusLabel">Status</label></td>
					<td>
						<select name=<%=Constants.KEY_STATUS%> id="statusSelect" onchange="changedStatus()">
							<option selected="selected" disabled="disabled" value="0">Select Status</option>
							<c:forEach var="status" items="${statuses}">
								<option value="${status.id}">
									<c:out value="${status}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label id="typeLabel">Type</label></td>
					<td>
						<select name=<%=Constants.KEY_TYPE%> id="typeSelect" onchange="changeType()">
							<option selected="selected" disabled="disabled" value="0">Select Type</option>
							<c:forEach items="${types}" var="type">
								<option value="${type.id}">
									<c:out value="${type}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label id="priorityLabel">Priority</label></td>
					<td>
						<select name=<%=Constants.KEY_PRIORITY%> id="prioritySelect" onchange="changePriority()">
							<option selected="selected" disabled="disabled" value="0">Select Priority</option>
							<c:forEach items="${priorities}" var="priority">
								<option value="${priority.id}">
									<c:out value="${priority}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label id="projectLabel">Project</label></td>
					<td>
						<select name=<%=Constants.KEY_PROJECT%> id="projectSelect" onchange="showBuilds()">
							<option selected="selected" disabled="disabled" value="0">Select Project</option>
							<c:forEach items="${projects}" var="project">
								<option value="${project.id}">
									<c:out value="${project}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label id="buildLabel">Build found</label></td>
					<td>
						<input type="text" id="notProjectSelect" value="Select Project before" readonly="readonly" style="display: block;">
						<c:forEach items="${projects}" var="project">
							<select name=<%=Constants.KEY_BUILD_FOUND%> id="buildSelect${project.id}" style="display: none;" onchange="changeBuild()">
								<option disabled="disabled" selected="selected" value="0">Select Build found</option>
								<c:forEach items="${project.getBuilds()}" var="build">
									<option value="${build.id}">
										<c:out value="${build}"></c:out>
									</option>
								</c:forEach>
							</select>
						</c:forEach>						
					</td>
				</tr>
				<tr>
					<td><label id="assignedLabel">Assignee</label></td>
					<td>
						<input type="text" id="notAssigned" value="Select Assigned status" readonly="readonly" style="display: block;">
						<select name=<%=Constants.KEY_ASSIGNEE%> id="assignedSelect" style="display: none;" onchange="changeAssignee()">
							<option selected="selected" disabled="disabled" value="0">Select User</option>
							<c:forEach var="assignee" items="${users}">
								<option value="${assignee.id }">
									<c:out value="${assignee }"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<div id="notValidForm" style="display: none;">
				Please fill in all fields.
			</div>
			<div>
				<input type="button" value="Add" onclick="addIssueValidation()"/>
				<input type="button" value="Back" onclick="history.back()"/>
			</div>
		</form>
	</div>
</body>
</html>
