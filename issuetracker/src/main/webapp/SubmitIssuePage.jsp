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
						<select name="status" id="status" onchange="changedStatus()">
							<option selected="selected" disabled="disabled">Select Status</option>
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
							<option selected="selected" disabled="disabled">Select Type</option>
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
							<option selected="selected" disabled="disabled">Select Priority</option>
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
						<select name="project" id="projectSelect" onchange="showBuilds()">
							<option selected="selected" disabled="disabled">Select Project</option>
							<c:set var="projects" value="<%=DAOFactory.getProjectDAO().getObs()%>"></c:set>
							<c:forEach items="${projects}" var="project">
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
						<input type="text" id="notProjectSelect" value="Select Project before" readonly="readonly" style="display: block;">
						<c:forEach items="${projects}" var="project">
							<select name="buildFound" id="buildSelect${project.id}" style="display: none;">
								<option disabled="disabled" selected="selected">Select Build found</option>
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
					<td><label>Assigned</label></td>
					<td>
						<input type="text" id="notAssigned" value="Select Assigned status" readonly="readonly" style="display: block;">
						<select name="assigned" id="assigned" style="display: none;">
							<option selected="selected" disabled="disabled">Select User</option>
							<c:forEach var="assignee" items="<%=DAOFactory.getUserDAO().getObs() %>">
								<option value="${assignee.id }">
									<c:out value="${assignee }"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="Add"/>
				<input type="button" value="Back" onclick="history.back()"/>
			</div>
		</form>
		<script type="text/javascript">
			function changedStatus(){
				var statusSelect = document.getElementById("status");
				var assigned = document.getElementById("assigned");
				var notAssigned = document.getElementById("notAssigned");
				if(statusSelect.value == 2){
					notAssigned.style.display = "none";
					assigned.style.display = "block";
				}else{
					assigned.style.display = "none";
					notAssigned.style.display = "block";
				}
			}
			
			var projectId = 0;
			function showBuilds(){
				var projectSelect = document.getElementById("projectSelect");
				if(projectId != 0){
					var buildSelect = document.getElementById("buildSelect" + projectId);
					buildSelect.style.display = "none";
				}
				projectId = projectSelect.value;
				var buildSelect = document.getElementById("buildSelect" + projectId);
				buildSelect.style.display = "block";
				document.getElementById("notProjectSelect").style.display = "none";
			}
		</script>
	</div>
</body>
</html>
