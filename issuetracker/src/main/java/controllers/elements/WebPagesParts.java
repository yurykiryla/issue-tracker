package controllers.elements;

import java.util.List;

import model.beans.Issue;
import model.beans.User;
import model.constants.Role;
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
		builder.append("<link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
		builder.append("<link rel=\"stylesheet\" href=\"css/styles.css\">\n");
		builder.append("</head>\n");
		builder.append("<body>\n");
		builder.append("<div class=\"main\">\n");
		builder.append("<header>\n");
		builder.append("<img src=\"images/issue-tracker-name.gif\" alt=\"Logo\">\n");
		builder.append("</header>\n");
		return builder.toString();
	}
	
	public static String getUserMenu(User user){
		StringBuilder builder = new StringBuilder();
		builder.append("<div class=\"user-auth\">\n");
		if(user == null){
			builder.append("<form name=\"loginForm\" action=\"/issuetracker/LoginController\" method=\"post\" class=\"login-form\">\n");
			builder.append("<label for=\"login\">E-mail</label>\n");
			builder.append("<input type=\"text\" name=\"login\" id=\"login\" required=\"required\" class=\"input-login\">\n");
			builder.append("<label for=\"password\">Password</label>\n");
			builder.append("<input type=\"password\" name=\"password\" id=\"password\" required=\"required\" class=\"input-password\">\n");
			builder.append("<input type=\"submit\" value=\"Login\" class=\"login-button\">\n");
			builder.append("</form>\n");
		}else{
			builder.append("<div class=\"user-welcome\">\n");
			builder.append("Welcome\n");
			
			builder.append("<ul class=\"menu\">\n");
			builder.append("<li><span class=\"user-welcome-name\">" + user.getFirstName() + "</span>\n");
			builder.append("<ul>\n");
			builder.append("<li><a href=\"#\">Chahge preferences</a></li>\n");
			builder.append("<li><a href=\"#\">Change password</a></li>\n");
			builder.append("<li><a href=\"/issuetracker/LogoutController\">Logout</a></li>\n");
			builder.append("</ul>\n");
			builder.append("</li>\n");
			builder.append("</ul>\n");
			builder.append("</div>\n");
			if(user.getRole() == Role.ADMINISTRATOR){
				builder.append("<div class=\"administrator-menu\">\n");
				builder.append("<ul class=\"menu\">\n");
				builder.append("<li><span class=\"administrator-menu-name\">Administrator menu</span>\n");
				builder.append("<ul>\n");
				builder.append("<li><a href=\"#\">Projects</a></li>\n");
				builder.append("<li><a href=\"#\">Statuses</a></li>\n");
				builder.append("<li><a href=\"#\">Resolutions</a></li>\n");
				builder.append("<li><a href=\"#\">Priorities</a></li>\n");
				builder.append("<li class=\"br\"><a href=\"#\">Types</a></li>\n");
				builder.append("<li><a href=\"#\">Add Project</a></li>\n");
				builder.append("<li><a href=\"#\">Add Resolution</a></li>\n");
				builder.append("<li><a href=\"#\">Add Priority</a></li>\n");
				builder.append("<li class=\"br\"><a href=\"#\">Add Type</a></li>\n");
				builder.append("<li><a href=\"#\">Search user</a></li>\n");
				builder.append("<li><a href=\"#\">Add new user</a></li>\n");
				builder.append("</ul>\n");
				builder.append("</li>\n");
				builder.append("</ul>\n");
				builder.append("</div>\n");
			}
			builder.append("<div class=\"submit-issue-block\">\n");
			builder.append("<button class=\"submit-issue-button\">Submit Issue</button>\n");
			builder.append("</div>\n");
		}
		
		builder.append("<div class=\"search-block\">\n");
		builder.append("<button class=\"search-button\">Search</button>\n");
		builder.append("</div>\n");
		builder.append("</div>\n");
		
		
		
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
			builder.append("<table class=\"issues-list\">\n");
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
				builder.append("<tr class=\"issues-row\">\n");
				builder.append("<td class=\"id-tab\">");
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
				builder.append(" priority-col\">" + issue.getPriority() + "</td>\n");
				builder.append("<td>" + issue.getAssignee().getFirstName() + " " + issue.getAssignee().getLastName() + "</td>\n");
				builder.append("<td>" + issue.getType() + "</td>\n");
				builder.append("<td>" + issue.getStatus() + "</td>\n");
				builder.append("<td class=\"summary-col\">" + issue.getSummary() + "</td>\n");
				builder.append("</tr>\n");
			}
			builder.append("</table>\n");
		}
		
		
		return builder.toString();
	}
	
	public static String getPageEnd(){
		return "</div>\n</body>\n</html>";
	}
	
	
}
