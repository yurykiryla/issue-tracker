<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.training.issuetracker.controllers.Constants"%>
<%@page import="org.training.issuetracker.model.enums.Status"%>
<%@page import="org.training.issuetracker.model.enums.Type"%>
<%@page import="org.training.issuetracker.model.enums.Priority"%>
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
							<option value=<%=Status.NEW%>><%=Status.NEW.toString()%></option>
							<option value=<%=Status.ASSIGNED%>><%=Status.ASSIGNED.toString()%></option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Type</label></td>
					<td>
						<select name="type" required="required">
							<option disabled="disabled">Select Type</option>
							<option value=<%=Type.COSMETIC%>><%=Type.COSMETIC.toString()%></option>
							<option value=<%=Type.BUG%>><%=Type.BUG.toString()%></option>
							<option value=<%=Type.FEATURE%>><%=Type.FEATURE.toString()%></option>
							<option value=<%=Type.PERFOMANCE%>><%=Type.PERFOMANCE.toString()%></option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Priority</label></td>
					<td>
						<select name="priority" required="required">
							<option disabled="disabled">Select Priority</option>
							<option value=<%=Priority.CRITICAL%>><%=Priority.CRITICAL.toString()%></option>
							<option value=<%=Priority.MAJOR%>><%=Priority.MAJOR.toString()%></option>
							<option value=<%=Priority.IMPORTANT%>><%=Priority.IMPORTANT.toString()%></option>
							<option value=<%=Priority.MINOR%>><%=Priority.MINOR.toString()%></option>
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