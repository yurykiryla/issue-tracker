package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Project;

public class ProjectHibernateDAO extends HibernateDAO<Project>{

	@Override
	protected Class<Project> getDAOClass() {
		return Project.class;
	}

}
