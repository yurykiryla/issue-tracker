package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.dao.exception.DAOException;

public interface BuildDAO extends DAO<Build> {
	public List<Build> getBuilds(Project project) throws DAOException;
}
