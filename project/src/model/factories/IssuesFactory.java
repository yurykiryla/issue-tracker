package model.factories;

import model.implementations.XmlIssueDAOImpl;
import model.interfaces.IIssueDAO;

public class IssuesFactory {
	public static IIssueDAO getClassFromFactory(){
		return new XmlIssueDAOImpl();
	}
}
