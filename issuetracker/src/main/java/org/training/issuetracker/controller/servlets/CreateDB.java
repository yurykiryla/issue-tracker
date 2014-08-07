package org.training.issuetracker.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Comment;
import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.Priority;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.bean.Resolution;
import org.training.issuetracker.model.bean.Status;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssueDAO;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;
import org.training.issuetracker.model.dao.hibernate.HibernateUtil;
import org.training.issuetracker.model.dao.hibernate.IssueHibernateDAO;
import org.training.issuetracker.model.dao.hibernate.TypeHibernateDAO;
import org.training.issuetracker.model.dao.hibernate.UserHibernateDAO;
import org.training.issuetracker.model.enums.Role;


//@WebServlet("/CreateDB")
public class CreateDB extends AbstractController {
	private static final long serialVersionUID = 1L;

    public CreateDB() {
        
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new User("admin", "admin", "admin", Role.ADMINISTRATOR, "admin"));
		session.save(new User("user", "user", "user", Role.USER, "user"));	
		session.save(new Status("New"));
		session.save(new Status("Assigned"));
		session.save(new Status("In Progress"));
		session.save(new Status("Resolved"));
		session.save(new Status("Closed"));
		session.save(new Status("Reopened"));
		session.save(new Resolution("Fixed"));
		session.save(new Resolution("Invalid"));
		session.save(new Resolution("Wontfix"));
		session.save(new Resolution("Worksforme"));
		session.save(new Priority("Critical"));
		session.save(new Priority("Major"));
		session.save(new Priority("Important"));
		session.save(new Priority("Minor"));
		session.save(new Type("Cosmetic"));
		session.save(new Type("Bug"));
		session.save(new Type("Feature"));
		session.save(new Type("Perfomance"));

		User manager = new User("admin", "admin", "admin", Role.ADMINISTRATOR, "admin");
		manager.setId(1);
		
		Project project = new Project();
		project.setName("pr1");
		project.setDescription("about pr1");
		project.setManager(manager);
		session.save(project);
		
		Build build = new Build();
		build.setName("1.0");
		
		build.setProject(project);
		project.getBuilds().add(build);
		
		session.save(build);

		/*
		Issue issue = new Issue();
		issue.setCreatedBy((User) session.load(User.class, 2));
		issue.setSummary("sum b1");
		issue.setDescription("descr b1");
		issue.setStatus((Status) session.load(Status.class, 1));
		issue.setType((Type) session.load(Type.class, 1));
		issue.setPriority((Priority) session.load(Priority.class, 1));
		issue.setProject((Project) session.load(Project.class, 1));
		issue.setBuildFound((Build) session.load(Build.class, 1));
		issue.setAssignee((User) session.load(User.class, 1));
		session.save(issue);
		
		Comment comment = new Comment();
		comment.setAddedBy(manager);
		comment.setIssue(issue);
		comment.setComment("comment to b1");
		session.save(comment);
		*/
		
		session.getTransaction().commit();
		session.close();
		
		/*
		try {
			IssueDAO issueDAO = DAOFactory.getIssueDAO();
			Issue issue = new Issue();
			issue.setCreatedBy(new User(1));
			issue.setSummary("sum b2");
			issue.setDescription("descr b2");
			issue.setStatus(new Status(2));
			issue.setType(new Type(2));
			issue.setPriority(new Priority(2));
			issue.setProject(new Project(1));
			issue.setBuildFound(new Build(1));
			issue.setAssignee(new User(2));
			issueDAO.addOb(issue);
			User user = DAOFactory.getUserDAO().getOb(2);
			List<Issue> issues = issueDAO.getSortedIssues(user, Configuration.get().getN(), "priority");
			for (Issue i : issues) {
				response.getWriter().println(i);
				response.getWriter().println("<br>");
			}
			issues = issueDAO.getSortedIssues(user, Configuration.get().getN(), "priority");
			for (Issue i : issues) {
				response.getWriter().println(i);
				response.getWriter().println("<br>");
			}
			
			UserDAO userDAO = DAOFactory.getUserDAO();
			User user = userDAO.getUser("admin", "admin");
			response.getWriter().println(user);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		*/
	}
}
