package org.swag.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewContactJaxBean {
	@XmlElement
	public String nom;
	@XmlElement
	public String prenom;
	@XmlElement
	public String mail;
	@XmlElement
	public String telephone;
	@XmlElement
	public Integer userId;
}