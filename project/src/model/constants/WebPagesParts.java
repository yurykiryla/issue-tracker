package model.constants;

import model.beans.Role;
import model.beans.User;

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
			builder.append("<form action=\"#\">\n");
			builder.append("<div>\n");
			builder.append("<label for=\"login\">Login</label>\n");
			builder.append("<input type=\"text\" name=\"login\" id=\"login\">\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<label for=\"password\">Password</label>\n");
			builder.append("<input type=\"text\" name=\"password\" id=\"password\">\n");
			builder.append("</div>\n");
			builder.append("<div>\n");
			builder.append("<a href=\"#\">Login</a>\n");
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
		builder.append("</table>\n");
		
		return builder.toString();
	}
	
	public static String getPageEnd(){
		return "</body>\n</html>";
	}
	
	
}
