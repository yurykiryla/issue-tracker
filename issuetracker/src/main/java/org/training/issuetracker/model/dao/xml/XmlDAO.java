package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.model.bean.Bean;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

public abstract class XmlDAO<T extends Bean> implements DAO<T> {
	@Override
	public T getOb(int id) throws DAOException {
		for (Element element : getElements()) {
			if (id == getId(element)) {
				return getOb(element);
			}
		}
		return null;
	}

	@Override
	public List<T> getObs() throws DAOException {
		List<T> list = new ArrayList<T>();
		for (Element element :getElements()) {
			list.add(getOb(element));
		}
		return list;
	}
	
	@Override
	public void addOb(T ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	public void changeOb(T ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}

	protected int getId(Element element) {
		return Integer.parseInt(element.getAttributeValue(Constants.KEY_ID));
	}
	
	protected abstract String getFilename();
	protected abstract T getOb(Element element) throws DAOException;
	
	protected List<Element> getElements() throws DAOException {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Configuration.get().getPath() + getFilename());
			return document.getRootElement().getChildren();
		} catch(JDOMException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}
}