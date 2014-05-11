package model.factories;

import model.implementations.SQLIssueDAOImpl;
import model.interfaces.IIssueDAO;

public class IssuesFactory {
	public static IIssueDAO getClassFromFactory(){
		return new SQLIssueDAOImpl();
	}
}
