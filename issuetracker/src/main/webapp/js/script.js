
function changedStatus() {
	document.getElementById("statusLabel").setAttribute("style", "color:inherit;");
	var statusSelect = document.getElementById("statusSelect");
	var assignedSelect = document.getElementById("assignedSelect");
	var notAssigned = document.getElementById("notAssigned");
	if (statusSelect.value == 2) {
		notAssigned.style.display = "none";
		assignedSelect.style.display = "block";
	} else {
		assignedSelect.style.display = "none";
		notAssigned.style.display = "block";
		document.getElementById("assignedLabel").setAttribute("style", "color:inherit;");
	}
}

var projectId = 0;
function showBuilds() {
	document.getElementById("projectLabel").setAttribute("style", "color:inherit;");
	var projectSelect = document.getElementById("projectSelect");
	if (projectId != 0) {
		var buildSelect = document.getElementById("buildSelect" + projectId);
		buildSelect.style.display = "none";
	}
	projectId = projectSelect.value;
	var buildSelect = document.getElementById("buildSelect" + projectId);
	buildSelect.style.display = "block";
	document.getElementById("notProjectSelect").style.display = "none";
}

function addIssueValidation() {
	var valid = true;
	
	if (document.getElementById("summaryInput").value.length == 0) {
		valid = false;
		document.getElementById("summaryLabel").setAttribute("style", "color: red;");
	}
	
	if (document.getElementById("descriptionInput").value.length == 0) {
		valid = false;
		document.getElementById("descriptionLabel").setAttribute("style", "color: red;");
	}
	
	var statusSelectValue = document.getElementById("statusSelect").value;
	if (statusSelectValue == 0) {
		valid = false;
		document.getElementById("statusLabel").setAttribute("style", "color: red;");
	} else if (statusSelectValue == 2) {
		if (document.getElementById("assignedSelect").value == 0) {
			valid = false;
			document.getElementById("assignedLabel").setAttribute("style", "color: red;");
		}
	}
	
	if (document.getElementById("typeSelect").value == 0) {
		valid = false;
		document.getElementById("typeLabel").setAttribute("style", "color: red;");
	}
	
	if (document.getElementById("prioritySelect").value == 0) {
		valid = false;
		document.getElementById("priorityLabel").setAttribute("style", "color: red;");
	}
	
	var projectSelectValue = document.getElementById("projectSelect").value;
	if (projectSelectValue == 0) {
		valid = false;
		document.getElementById("projectLabel").setAttribute("style", "color: red;");
	} else if (document.getElementById("buildSelect" + projectSelectValue).value == 0) {
		valid = false;
		document.getElementById("buildLabel").setAttribute("style", "color: red;");
	}
	
	if (valid) {
		document.getElementById("submitIssueForm").submit();
	} else {
		document.getElementById("notValidForm").setAttribute("style", "color: red;");
	}
}

function changeSummary() {
	document.getElementById("summaryLabel").setAttribute("style", "color:inherit;");
}

function changeDescription() {
	document.getElementById("descriptionLabel").setAttribute("style", "color:inherit;");
}

function changeType() {
	document.getElementById("typeLabel").setAttribute("style", "color:inherit;");
}

function changePriority() {
	document.getElementById("priorityLabel").setAttribute("style", "color:inherit;");
}

function changeBuild() {
	document.getElementById("buildLabel").setAttribute("style", "color:inherit;");
}

function changeAssignee() {
	document.getElementById("assignedLabel").setAttribute("style", "color:inherit;");
}