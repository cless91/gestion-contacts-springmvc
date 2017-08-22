package org.swag;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.swag.dao.ContactsDAO;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class Main {

	@Autowired
	private ContactsDAO contactsDAO;

	protected void create() {
		// code to save a book
	}

	protected void read() {
		// code to get a book
	}

	protected void update() {
		// code to modify a book
	}

	protected void delete() {
		// code to remove a book
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Main main = context.getBean(Main.class);

		main.testCreateContacts();

		((ConfigurableApplicationContext) context).close();
	}

	private void testCreateContacts() {
		for (int i = 0; i < 10; i++) {
			contactsDAO.createContact(2, "user" + i, "user" + i, "user" + i + "@" + "user" + i + ".com",
					"0" + 800000000 + i);
		}
	}
}
