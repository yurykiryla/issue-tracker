package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Type;

public class TypeXmlDAO extends XmlDAO<Type> {
	public TypeXmlDAO() {
		super();
	}

	@Override
	protected String getFilename() {
		return Constants.TYPES_XML_FILENAME;
	}

	@Override
	protected Type getOb(Element element) {
		String name = element.getChildText(Constants.KEY_NAME);
		return new Type();
	}
}