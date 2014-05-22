/**
 * 
 */

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