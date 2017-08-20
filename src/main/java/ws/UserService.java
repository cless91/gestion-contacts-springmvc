package ws;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ContactsDAO;
import dao.impl.ContactsDAOImpl;

@Path("/user")
public class UserService {

	@Context
	private UriInfo context;

	private ContactsDAO contactsDAO;

	protected void setup() {
		SessionFactory sessionFactory;
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
			contactsDAO.setSessionFactory(sessionFactory);
			this.setContactsDAO(contactsDAO);
		} catch (Exception ex) {
			ex.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@GET
	@Path("{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public String getContacts() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// User user = new User();

		// Object to JSON in String
		if (contactsDAO == null) {
			setup();
		}
		String jsonInString = mapper.writeValueAsString(contactsDAO.getContacts());
		return jsonInString;
	}

	public void setContactsDAO(ContactsDAO contactsDAO) {
		this.contactsDAO = contactsDAO;
	}
}
