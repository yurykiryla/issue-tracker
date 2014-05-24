package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Status;

public class StatusXmlDAO extends XmlDAO<Status> {
	public StatusXmlDAO() {
	}

	@Override
	protected String getFilename() {
		return Constants.STATUSES_XML_FILENAME;
	}

	@Override
	protected Status getOb(Element element) {
		String name = element.getChildText(Constants.KEY_NAME);
		return new Status(getId(element), name);
	}
}