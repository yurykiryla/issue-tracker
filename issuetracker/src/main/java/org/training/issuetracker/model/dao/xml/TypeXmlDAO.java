/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Type;

/**
 * @author Yury
 *
 */
public class TypeXmlDAO extends XmlDAO<Type> {

	/**
	 * 
	 */
	public TypeXmlDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getFilename()
	 */
	@Override
	protected String getFilename() {
		// TODO Auto-generated method stub
		return Constants.TYPES_XML_FILENAME;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getOb(org.jdom2.Element)
	 */
	@Override
	protected Type getOb(Element element) {
		// TODO Auto-generated method stub
		String name = element.getChildText(Constants.KEY_NAME);
		return new Type(getId(element), name);
	}
	
}
