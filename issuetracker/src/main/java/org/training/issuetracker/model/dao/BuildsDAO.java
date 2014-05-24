package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public interface BuildsDAO {
	public List<Build> getBuilds(int projectId) throws DAOException;
	public void addBuild(Build build, int projectId) throws DAOException;
}