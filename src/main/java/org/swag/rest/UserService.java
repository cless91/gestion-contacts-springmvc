package org.swag.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swag.dao.ContactsDAO;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("/hello")
public class UserService {

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private ContactsDAO contactsDAO;

	@GET
	@Path("/toto")
	public String home() {
		return "Hello World!";
	}

	@GET
	@Path("/contacts")
	public String getContacts() throws JsonGenerationException, JsonMappingException, IOException {
		String jsonInString = this.mapper.writeValueAsString(contactsDAO.getContacts());
		return jsonInString;
	}

	public void setContactsDAO(ContactsDAO contactsDAO) {
		this.contactsDAO = contactsDAO;
	}
}
