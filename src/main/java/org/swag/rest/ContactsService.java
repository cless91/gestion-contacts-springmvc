package org.swag.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swag.dao.ContactsDAO;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("/")
public class ContactsService {

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private ContactsDAO contactsDAO;

	@GET
	@Path("/toto")
	public String home() {
		return "Hello World!";
	}

	@GET
	@Path("/getContacts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getContacts() throws JsonGenerationException, JsonMappingException, IOException {
		String jsonInString = this.mapper.writeValueAsString(contactsDAO.getContacts());
		return jsonInString;
	}

	@POST
	@Path("/createContact")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createContact(final NewContactJaxBean nouveauContact)
			throws JsonGenerationException, JsonMappingException, IOException {
		JSONObject retour = new JSONObject();
		try {
			contactsDAO.createContact(nouveauContact.userId, nouveauContact.nom, nouveauContact.prenom,
					nouveauContact.mail, nouveauContact.telephone);
			retour.put("status", "ok");
			retour.put("contacts", contactsDAO.getContacts());
		} catch (Exception e) {
			retour.put("status", "error");
			retour.put("errorMessage", e.getMessage());
		}
		return retour.toString();

	}

	@DELETE
	@Path("/deleteContact/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteContact(@PathParam("id") Integer id)
			throws JsonGenerationException, JsonMappingException, IOException {
		JSONObject retour = new JSONObject();
		try {
			contactsDAO.deleteContact(id);
			retour.put("status", "ok");
			retour.put("contacts", contactsDAO.getContacts());
		} catch (Exception e) {
			retour.put("status", "error");
			retour.put("errorMessage", e.getMessage());
		}

		return retour.toString();
	}
}
