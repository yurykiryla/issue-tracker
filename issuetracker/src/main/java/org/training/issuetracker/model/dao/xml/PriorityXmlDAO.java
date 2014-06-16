package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Priority;

public class PriorityXmlDAO extends XmlDAO<Priority> {
	public PriorityXmlDAO() {
		super();
	}

	@Override
	protected String getFilename() {
		return Constants.PRIORITIES_XML_FILENAME;
	}

	@Override
	protected Priority getOb(Element element) {
		String name = element.getChildText(Constants.KEY_NAME);
		return new Priority();
	}
}