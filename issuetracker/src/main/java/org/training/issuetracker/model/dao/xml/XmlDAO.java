/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.properties.Config;

/**
 * @author Yury
 *
 */
public abstract class XmlDAO<T extends Beans> implements DAO<T> {

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.DAO#getOb(int)
	 */
	@Override
	public T getOb(int id) throws DAOException {
		// TODO Auto-generated method stub
		for(Element element : getElements()){
			if(id == getId(element)){
				return getOb(element);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.DAO#getObs()
	 */
	@Override
	public List<T> getObs() throws DAOException {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<>();
		for(Element element :getElements()){
			list.add(getOb(element));
		}
		return list;
	}
	
	protected int getId(Element element){
		return Integer.parseInt(element.getAttributeValue(Constants.KEY_ID));
	}
	
	protected abstract String getFilename();
	protected abstract T getOb(Element element);
	
	protected List<Element> getElements() throws DAOException{
		try{
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Config.getConfig().getPath() + getFilename());
			return document.getRootElement().getChildren();
		}catch(JDOMException | IOException e){
			throw new DAOException(e);
		}
	}
}
