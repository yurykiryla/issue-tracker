package model.constants;

import java.util.List;

import model.beans.Issue;
import model.beans.User;
import model.factories.IssuesFactory;

/**
 * @author Yury Kiryla
 *
 */
public class WebPagesParts {
	public static String getPageHead(String title){
		StringBuilder builder = new StringBuilder();
		builder.append("<!doctype html>\n");
		builder.append("<html lang=\"en\">\n");
		builder.append("<head>\n");
		builder.append("<meta charset=\"UTF-8\">\n");
		builder.append("<title>" + title + "</title>\n");
		builder.append("</head>\n");
		builder.append("<body>");
		return builder.toString();
	}
	
	public static String getUserMenu(User user){
		StringBuilder builder = new StringBuilder();
		if(user == null){
			builder.append("<form name=\"loginForm\" action=\"/project/LoginController\" method=\"post\">\n");
			builder.append("<div>\n");
			builder.append("<label for=\"login\">Login</label>\n");
			builder.append("<input type=\"text\" name=\"login\" id=\"login\" required=\"required\">\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<label for=\"password\">Password</label>\n");
			builder.append("<input type=\"password\" name=\"password\" id=\"password\" required=\"required\">\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"JavaScript:document.loginForm.submit()\">Login</a>\n");
			builder.append("</div>\n");
			builder.append("</form>\n");
		}else{
			builder.append("<div>\n");
			builder.append("Welcome <span>" + user.getFirstName() + "</span>\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"#\">Chahge preferences</a>\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"#\">Change password</a>\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<button>Logout</button>\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<button>Submit Issue</button>\n");
			builder.append("</div>\n");
		}
		
		builder.append("<div>\n");
		builder.append("<button>Search</button>\n");
		builder.append("</div>\n");
		
		if(user != null && user.getRole() == Role.ADMINISTRATOR){
			builder.append("<ul>\n");
			builder.append("<li><a href=\"#\">Projects</a></li>\n");
			builder.append("<li><a href=\"#\">Statuses</a></li>\n");
			builder.append("<li><a href=\"#\">Resolutions</a></li>\n");
			builder.append("<li><a href=\"#\">Priorities</a></li>\n");
			builder.append("<li><a href=\"#\">Types</a></li>\n");
			builder.append("</ul>\n");
			builder.append("<ul>\n");
			builder.append("<li><a href=\"#\">Add Project</a></li>\n");
			builder.append("<li><a href=\"#\">Add Resolution</a></li>\n");
			builder.append("<li><a href=\"#\">Add Priority</a></li>\n");
			builder.append("<li><a href=\"#\">Add Type</a></li>\n");
			builder.append("</ul>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"#\">Search user</a>\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"#\">Add new user</a>\n");
			builder.append("</div>\n");
		}
		
		//builder.append("\n");
		
		return builder.toString();
	}
	
	public static String getIssuesList(User user){
		StringBuilder builder = new StringBuilder();
		List<Issue> issues = IssuesFactory.getClassFromFactory().getIssues(user, 10);
		if(issues.isEmpty()){
			builder.append("<div>\n");
			if(user == null){
				builder.append("Issues list is empty");
			}else{
				builder.append("Not assigned issues");
			}
			builder.append("</div>\n");
		}else{
			builder.append("<table>\n");
			builder.append("<thead>\n");
			builder.append("<tr>\n");
			builder.append("<th>Id</th>\n");
			builder.append("<th>Priority</th>\n");
			builder.append("<th>Assignee</th>\n");
			builder.append("<th>Type</th>\n");
			builder.append("<th>Status</th>\n");
			builder.append("<th>Summary</th>\n");
			builder.append("</tr>\n");
			builder.append("</thead>\n");
			for(Issue issue : issues){
				builder.append("<tr>\n");
				builder.append("<td>");
				if(user == null){
					//view issue
					builder.append("<a href=\"#\">");
				}else{
					//change issue
					builder.append("<a href=\"#\">");
				}
				builder.append(issue.getId() + "</a>");
				builder.append("</td>\n");
				builder.append("<td class=\"");
				switch(issue.getPriority()){
					case CRITICAL:
						builder.append("priority-critical");
						break;
					case IMPORTANT:
						builder.append("priority-important");
						break;
					case MAJOR:
						builder.append("priority-major");
						break;
					case MINOR:
						builder.append("priority-minor");
						break;
				}
				builder.append("\">" + issue.getPriority() + "</td>\n");
				builder.append("<td>" + issue.getAssignee().getFirstName() + " " + issue.getAssignee().getLastName() + "</td>\n");
				builder.append("<td>" + issue.getType() + "</td>\n");
				builder.append("<td>" + issue.getStatus() + "</td>\n");
				builder.append("<th>" + issue.getSummary() + "</th>\n");
				builder.append("</tr>\n");
			}
			builder.append("</table>\n");
		}
		
		
		return builder.toString();
	}
	
	public static String getPageEnd(){
		return "</body>\n</html>";
	}
	
	
}
