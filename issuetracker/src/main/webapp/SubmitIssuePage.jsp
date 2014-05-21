<%@page import="org.training.issuetracker.model.beans.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@page import="org.training.issuetracker.model.dao.factories.DAOFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=Constants.SUBMIT_ISSUE_PAGE_TITLE %></title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/SubmitIssue.js"></script>
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userMenu.jsp"></jsp:include>
		<form class="submit-issue">
			<table class="submit-issue-table">
				<tr>
					<td><label>Summary</label></td>
					<td><input type="text" name="summary"/></td>
				</tr>
				<tr>
					<td><label>Description</label></td>
					<td><textarea rows="5" cols="50" name="description" ></textarea></td>
				</tr>
				<tr>
					<td><label>Status</label></td>
					<td>
						<select name="status" id="status">
							<option disabled="disabled">Select Status</option>
							<option value=<%=DAOFactory.getStatusDAO().getOb(1).getId()%>>
								<%=DAOFactory.getStatusDAO().getOb(1).toString()%>
							</option>
							<option value=<%=DAOFactory.getStatusDAO().getOb(2).getId()%>>
								<%=DAOFactory.getStatusDAO().getOb(2).toString()%>
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Type</label></td>
					<td>
						<select name="type" >
							<option disabled="disabled">Select Type</option>
							<c:forEach items="<%=DAOFactory.getTypeDAO().getObs()%>" var="type">
								<option value="${type.id}">
									<c:out value="${type}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Priority</label></td>
					<td>
						<select name="priority" >
							<option disabled="disabled">Select Priority</option>
							<c:forEach items="<%=DAOFactory.getPriorityDAO().getObs()%>" var="priority">
								<option value="${priority.id}">
									<c:out value="${priority}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Project</label></td>
					<td>
						<select name="project" >
							<option disabled="disabled">Select Project</option>
							<c:forEach items="<%=DAOFactory.getProjectDAO().getObs()%>" var="project">
								<option value="${project.id}">
									<c:out value="${project}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Build found</label></td>
					<td>
						<select name="buildFound">
							<option disabled="disabled" selected="selected">Select Build found</option>
							<option disabled="disabled">Select Project before</option>
							<c:forEach items="<%=DAOFactory.getProjectDAO().getObs()%>" var="project">
								<c:set var="buildsDAO" value="<%=DAOFactory.getBuildsDAO() %>"></c:set>
								<c:forEach var="build" items="${buildsDAO.getBuilds(project.id) }">
									<option id="${project.id}" value="${build.id}" style="display: none;">
										<c:out value="${build}"></c:out>
									</option>
								</c:forEach>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Assigned</label></td>
					<td id="assignedRow">
						<select name="assigned" id="assignedSelect"></select>
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="Add"/>
				<input type="button" value="Back" onclick="history.back()"/>
			</div>
		</form>
	</div>
</body>
</html>
