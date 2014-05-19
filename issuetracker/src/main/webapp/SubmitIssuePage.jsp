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
					<td><input type="text" name="summary" required="required"/></td>
				</tr>
				<tr>
					<td><label>Description</label></td>
					<td><textarea rows="5" cols="50" name="description" required="required"></textarea></td>
				</tr>
				<tr>
					<td><label>Status</label></td>
					<td>
						<select name="status" required="required">
							<option disabled="disabled">Select Status</option>
							<option value=<%=DAOFactory.getStatusDAO().getOb(1)%>>
								<%=DAOFactory.getStatusDAO().getOb(1).toString()%>
							</option>
							<option value=<%=DAOFactory.getStatusDAO().getOb(2)%>>
								<%=DAOFactory.getStatusDAO().getOb(2).toString()%>
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Type</label></td>
					<td>
						<select name="type" required="required">
							<option disabled="disabled">Select Type</option>
							<c:forEach items="<%=DAOFactory.getTypeDAO().getObs()%>" var="type">
								<option value="${type}">
									<c:out value="${type}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Priority</label></td>
					<td>
						<select name="priority" required="required">
							<option disabled="disabled">Select Priority</option>
							<c:forEach items="<%=DAOFactory.getPriorityDAO().getObs()%>" var="priority">
								<option value="${priority}">
									<c:out value="${priority}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Project</label></td>
					<td>
						<select name="project" required="required">
							<option disabled="disabled">Select Project</option>
							<c:forEach items="<%=DAOFactory.getProjectDAO().getObs()%>" var="project">
								<option value="${project}">
									<c:out value="${project}"></c:out>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Build found</label></td>
					<td>
						<select name="buildFound" required="required">
							<option disabled="disabled">Select Build found</option>
							<option disabled="disabled">Select Project before</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Assigned</label></td>
					<td>
						<select name="assigned" required="required">
							<option disabled="disabled">Select Assigned User</option>
							<option disabled="disabled">Select Status 'Assigned' before</option>
						</select>
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
