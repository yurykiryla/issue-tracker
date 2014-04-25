package model;

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
	
	public static String getPageEnd(){
		return "</body>\n</html>";
	}
	
	
}
