package org.training.issuetracker.controllers;

import org.training.issuetracker.model.properties.Config;

public class Constants {
	public static final String CONTEXT_PATH = Config.getConfig().getContextPath();
	public static final String ADD_ISSUE_FORM_ACTION = CONTEXT_PATH + "/AddIssueController";
	public static final String ERROR_PAGE_TITLE = "Error page";
	public static final String KEY_ASSIGNEE = "assignee";
	public static final String KEY_BUILD_FOUND = "buildFound";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_ERROR = "error";
	public static final String KEY_IMPLEMENTATION = "implementation";
	public static final String KEY_ISSUES = "issues";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_N = "n";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_PRIORITY = "priority";
	public static final String KEY_PROJECT = "project";
	public static final String KEY_SORT = "sortRow";
	public static final String KEY_STATUS = "status";
	public static final String KEY_SUMMARY = "summary";
	public static final String KEY_TYPE = "type";
	public static final String KEY_USER = "user";
	public static final String LOGIN_FORM_ACTION = CONTEXT_PATH + "/LoginController";
	public static final String RESOURCES_PATH = "WEB-INF\\classes\\";
	public static final String ROOT_PATH = "/";
	public static final String SUBMIT_ISSUE_PAGE_TITLE = "Submit Issue";
	public static final String URL_ERROR_PAGE = "/jsp/ErrorPage.jsp";
	public static final String URL_LOGOUT = CONTEXT_PATH + "/LogoutController";
	public static final String URL_SORT_ISSUES_CONTROLLER = CONTEXT_PATH + "/SortIssuesController?" 
															+ KEY_SORT + "=";
	public static final String URL_SUBMIT_ISSUE_CONTROLLER = CONTEXT_PATH + "/SubmitIssueController";
	public static final String URL_SUBMIT_ISSUE_PAGE = "/jsp/SubmitIssuePage.jsp";
	public static final String URL_WELCOM_PAGE = "/jsp/WelcomePage.jsp";
	public static final String URL_WELCOM_PAGE_CONTROLLER = "/WelcomePageController";
	public static final String USERS_XML_FILENAME = "Users.xml";
	public static final String WELCOM_PAGE_TITLE = "Welcom page / Dashboard";
}
