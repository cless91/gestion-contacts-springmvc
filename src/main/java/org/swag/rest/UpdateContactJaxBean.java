package org.swag.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateContactJaxBean extends NewContactJaxBean {
	@XmlElement
	public Integer contactId;
}