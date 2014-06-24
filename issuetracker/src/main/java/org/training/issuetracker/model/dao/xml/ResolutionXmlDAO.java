package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.bean.Resolution;

public class ResolutionXmlDAO extends XmlDAO<Resolution>{
	public ResolutionXmlDAO() {
	}

	@Override
	protected String getFilename() {
		return Constants.RESOLUTIONS_XML_FILENAME;
	}

	@Override
	protected Resolution getOb(Element element) {
		String name = element.getChildText(Constants.KEY_NAME);
		return new Resolution();
	}
}