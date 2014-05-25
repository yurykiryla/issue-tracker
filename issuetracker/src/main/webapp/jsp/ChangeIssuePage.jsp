<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=Constants.CHANGE_ISSUE_PAGE_TITLE %></title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userMenu.jsp"></jsp:include>
		<form id="changeIssueForm" class="change-issue" action="<%=Constants.CHANGE_ISSUE_FORM_ACTION%>">
			<table class="change-issue-table">
				<tr>
					<td><label>Id</label></td>
					<td><input type="text" name=<%=Constants.KEY_ID%> value="${issue.id}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label>Create Date</label></td>
					<td><input type="text" value="${issue.createDate}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label>Created By</label></td>
					<td><input type="text" value="${issue.createdBy}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label>Modify Date</label></td>
					<td><input type="text" value="${issue.modifyDate}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label>Modified By</label></td>
					<td><input type="text" value="${issue.modifiedBy}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label id="summaryLabel">Summary</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.summary}" readonly="readonly"/>
							</c:when>
							<c:otherwise>
								<input type="text" name=<%=Constants.KEY_SUMMARY%> id="summaryInput" value="${issue.summary}" onchange="changeSummary()"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label id="descriptionLabel">Description</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<textarea rows="5" cols="50" readonly="readonly">${issue.description}</textarea>
							</c:when>
							<c:otherwise>
								<textarea rows="5" cols="50" name=<%=Constants.KEY_DESCRIPTION%> id="descriptionInput" onchange="changeDescription()">${issue.description}</textarea>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label>Status</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 1}">
								<select name=<%=Constants.KEY_STATUS%> id="statusSelect" onchange="changedStatus()">
									<option value="1" selected="selected">${statuses[0]}</option>
									<option value="2">${statuses[1]}</option>
								</select>
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_STATUS%> id="statusSelect" onchange="changeStatus()">
									<c:choose>
										<c:when test="${issue.status.id == 2}">
											<option value="2" selected="selected">${statuses[1]}</option>
											<option value="3">${statuses[2]}</option>
										</c:when>
										<c:when test="${issue.status.id == 3}">
											<option value="3" selected="selected">${statuses[2]}</option>
											<option value="4">${statuses[3]}</option>
											<option value="5">${statuses[4]}</option>
										</c:when>
										<c:when test="${issue.status.id == 4}">
											<option value="4" selected="selected">${statuses[3]}</option>
											<option value="5">${statuses[4]}</option>
										</c:when>
										<c:when test="${issue.status.id == 5}">
											<option value="5" selected="selected">${statuses[4]}</option>
											<option value="6">${statuses[5]}</option>
										</c:when>
									</c:choose>
								</select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<c:if test="${issue.status.id >= 3}">
					<tr>
						<td><label id="resolutionLabel">Resolution</label></td>
						<td>
							<c:choose>
								<c:when test="${issue.status.id == 5}">
									<input type="text" value="${issue.resolution}" readonly="readonly">
								</c:when>
								<c:when test="${issue.status.id == 4}">
									<select name="<%=Constants.KEY_RESOLUTION%>" id="resolutionSelect">
										<c:forEach var="resolution" items="${resolutions}">
											<c:choose>
												<c:when test="${resolution.id == issue.resolution.id}">
													<option value="${resolution.id}" selected="selected">${resolution}</option>
												</c:when>
												<c:otherwise>
													<option value="${resolution.id}">${resolution}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</c:when>
								<c:otherwise>
									<input type="text" id="notResolved" value="Select Resolved or Closed status" readonly="readonly" style="display: block;">
									<select name="<%=Constants.KEY_RESOLUTION%>" id="resolutionSelect" style="display: none;" onchange="changeResolution()">
										<option selected="selected" disabled="disabled" value="0">Select Resolution</option>
										<c:forEach var="resolution" items="${resolutions}">
											<option value="${resolution.id}">${resolution}</option>
										</c:forEach>
									</select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:if>
				<tr>
					<td><label>Type</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.type}" readonly="readonly">
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_TYPE%>>
									<c:forEach items="${types}" var="type">
										<c:choose>
											<c:when test="${type.id == issue.type.id}">
												<option value="${type.id}" selected="selected">${type}</option>
											</c:when>
											<c:otherwise>
												<option value="${type.id}">${type}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label>Priority</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.priority}" readonly="readonly">
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_PRIORITY%>>
									<c:forEach items="${priorities}" var="priority">
										<c:choose>
											<c:when test="${priority.id == issue.priority.id}">
												<option value="${priority.id}" selected="selected">${priority}</option>
											</c:when>
											<c:otherwise>
												<option value="${priority.id}">${priority}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label>Project</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.project}" readonly="readonly">
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_PROJECT%> onchange="changeProject()">
									<c:forEach items="${projects}" var="project">
										<c:choose>
											<c:when test="${project.id == issue.project.id}">
												<option value="${project.id}" selected="selected">${project}</option>
											</c:when>
											<c:otherwise>
												<option value="${project.id}">${project}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label id="buildLabel">Build found</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.buildFound}" readonly="readonly">
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_BUILD_FOUND%> id="notChangedProject" style="display: block;">
									<c:forEach items="${issue.project.builds}" var="build">
										<c:choose>
											<c:when test="${build.id == issue.buildFound.id}">
												<option value="${build.id}" selected="selected">${build}</option>
											</c:when>
											<c:otherwise>
												<option value="${build.id}">${build}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								<c:forEach items="${projects}" var="project">
									<select name=<%=Constants.KEY_BUILD_FOUND%> id="buildSelect${project.id}" style="display: none;" onchange="changeBuild()">
										<option disabled="disabled" selected="selected" value="0">Select Build found</option>
										<c:forEach items="${project.builds}" var="build">
											<option value="${build.id}">
												<c:out value="${build}"></c:out>
											</option>
										</c:forEach>
									</select>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td><label id="assignedLabel">Assignee</label></td>
					<td>
						<c:choose>
							<c:when test="${issue.status.id == 5}">
								<input type="text" value="${issue.assignee}" readonly="readonly">
							</c:when>
							<c:when test="${issue.status.id == 1}">
								<input type="text" id="notAssigned" value="Select Assigned status" readonly="readonly" style="display: block;">
								<select name=<%=Constants.KEY_ASSIGNEE%> id="assignedSelect" style="display: none;" onchange="changeAssignee()">
									<option selected="selected" disabled="disabled" value="0">Select User</option>
									<c:forEach var="assignee" items="${users}">
										<option value="${assignee.id }">
											<c:out value="${assignee }"></c:out>
										</option>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name=<%=Constants.KEY_ASSIGNEE%>>
									<c:forEach items="${users}" var="user">
										<c:choose>
											<c:when test="${user.id == issue.assignee.id}">
												<option value="${user.id}" selected="selected">${user}</option>
											</c:when>
											<c:otherwise>
												<option value="${user.id}">${user}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
			<div id="notValidForm" style="display: none;">
				Please fill in all fields.
			</div>
			<div>
				<input type="button" value="Update" onclick="updateIssue()"/>
				<input type="button" value="Back" onclick="history.back()"/>
			</div>
		</form>
	</div>
</body>
</html>