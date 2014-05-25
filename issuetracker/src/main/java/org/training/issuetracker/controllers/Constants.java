package org.training.issuetracker.controllers;

import org.training.issuetracker.model.properties.Config;

public class Constants {
	public static final String CONTEXT_PATH = Config.getConfig().getContextPath();
	public static final String ADD_ISSUE_FORM_ACTION = CONTEXT_PATH + "/AddIssueController";
	public static final String CHANGE_ISSUE_FORM_ACTION = CONTEXT_PATH + "/UpdateIssueController";
	public static final String CHANGE_ISSUE_PAGE_TITLE = "Change Issue";
	public static final String ERROR_PAGE_TITLE = "Error page";
	public static final int ID_STATUS_ASSIGNED = 2;
	public static final int ID_STATUS_CLOSED = 5;
	public static final int ID_STATUS_NEW = 1;
	public static final int ID_STATUS_REOPENED = 6;
	public static final int ID_STATUS_RESOLVED = 4;
	public static final String KEY_ASSIGNEE = "assignee";
	public static final String KEY_BUILD_FOUND = "buildFound";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_ERROR = "error";
	public static final String KEY_ID = "id";
	public static final String KEY_IMPLEMENTATION = "implementation";
	public static final String KEY_ISSUE = "issue";
	public static final String KEY_ISSUE_ID = "issueId";
	public static final String KEY_ISSUES = "issues";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_MESSAGE = "message";
	public static final String KEY_N = "n";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_PRIORITIES = "priorities";
	public static final String KEY_PRIORITY = "priority";
	public static final String KEY_PROJECT = "project";
	public static final String KEY_PROJECTS = "projects";
	public static final String KEY_RESOLUTION = "resolution";
	public static final String KEY_RESOLUTIONS = "resolutions";
	public static final String KEY_SORT = "sortRow";
	public static final String KEY_STATUS = "status";
	public static final String KEY_STATUSES = "statuses";
	public static final String KEY_SUMMARY = "summary";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TYPES = "types";
	public static final String KEY_USER = "user";
	public static final String KEY_USERS = "users";
	public static final String LOGIN_FORM_ACTION = CONTEXT_PATH + "/LoginController";
	public static final String MESSAGE_ADD_ISSUE = "Issue is added";
	public static final String MESSAGE_CHANGE_ISSUE = "Issue is changed";
	public static final String OPERATION_RESULT_PAGE_TITLE = "Operation result";
	public static final String RESOURCES_PATH = "WEB-INF\\classes\\";
	public static final String ROOT_PATH = "/";
	public static final String SUBMIT_ISSUE_PAGE_TITLE = "Submit Issue";
	public static final String URL_CHANGE_ISSUE_CONTROLLER = CONTEXT_PATH + "/ChangeIssueController?" 
			+ KEY_ISSUE_ID + "=";
	public static final String URL_CHANGE_ISSUE_PAGE = "/jsp/ChangeIssuePage.jsp";
	public static final String URL_ERROR_PAGE = "/jsp/ErrorPage.jsp";
	public static final String URL_LOGOUT = CONTEXT_PATH + "/LogoutController";
	public static final String URL_OPERATION_RESULT_PAGE = "/jsp/OperationResult.jsp";
	public static final String URL_SORT_ISSUES_CONTROLLER = CONTEXT_PATH + "/SortIssuesController?" 
															+ KEY_SORT + "=";
	public static final String URL_SUBMIT_ISSUE_CONTROLLER = CONTEXT_PATH + "/SubmitIssueController";
	public static final String URL_SUBMIT_ISSUE_PAGE = "/jsp/SubmitIssuePage.jsp";
	public static final String URL_VIEW_ISSUE_PAGE = "/jsp/ViewIssuePage.jsp";
	public static final String URL_WELCOM_PAGE = "/jsp/WelcomePage.jsp";
	public static final String URL_WELCOM_PAGE_CONTROLLER = "/WelcomePageController";
	public static final String URL_WELCOM_PAGE_CONTROLLER_FROM_JSP = CONTEXT_PATH + URL_WELCOM_PAGE_CONTROLLER;
	public static final String USERS_XML_FILENAME = "Users.xml";
	public static final String VIEW_ISSUE_PAGE_TITLE = "View Issue";
	public static final String WELCOM_PAGE_TITLE = "Welcom page / Dashboard";
}
