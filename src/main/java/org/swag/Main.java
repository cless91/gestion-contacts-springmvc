package org.swag;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dao.impl.ContactsDAOImpl;
import dao.impl.UsersDAOImpl;
import entities.Contact;
import entities.User;
import ws.UserService;

public class Main {
	protected SessionFactory sessionFactory;

	protected void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("coucou");
		} catch (Exception ex) {
			ex.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	protected void exit() {
		// code to close Hibernate Session factory
		sessionFactory.close();
	}

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
		Main main = new Main();
		main.setup();

		main.testServiceGetContacts();

		main.exit();
	}

	private void testCreateContacts() {
		ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
		contactsDAO.setSessionFactory(sessionFactory);
		for (int i = 0; i < 10; i++) {
			contactsDAO.createContact(2, "user" + i, "user" + i, "user" + i + "@" + "user" + i + ".com",
					"0" + 800000000 + i);
		}
		sessionFactory.close();
	}

	private void testUpdateContact() {
		ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
		contactsDAO.setSessionFactory(sessionFactory);
		contactsDAO.updateContact(2, "joseph", "cless", "joseph@joseph.com", "0836656565");
		sessionFactory.close();
	}

	private void testDeleteContact() {
		ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
		contactsDAO.setSessionFactory(sessionFactory);
		contactsDAO.deleteContact(2);
		sessionFactory.close();
	}

	private void testGetContacts() {
		ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
		contactsDAO.setSessionFactory(sessionFactory);
		List<Contact> results = contactsDAO.getContactsByUserId(2);
		results.forEach(item -> System.out.println(item));
		sessionFactory.close();
	}

	private void testCreateUser() {
		UsersDAOImpl usersDAO = new UsersDAOImpl();
		usersDAO.setSessionFactory(sessionFactory);
		usersDAO.createUser("admin", "admin", "admin");
		sessionFactory.close();
	}

	private void testGetUsers() {
		UsersDAOImpl usersDAO = new UsersDAOImpl();
		usersDAO.setSessionFactory(sessionFactory);
		List<User> results = usersDAO.getUsers();
		results.forEach(item -> System.out.println(item));
		sessionFactory.close();
	}

	private void testUpdateUser() {
		UsersDAOImpl usersDAO = new UsersDAOImpl();
		usersDAO.setSessionFactory(sessionFactory);
		usersDAO.updateUser(4, "admin", "toto", "admin");
		sessionFactory.close();
	}

	private void testDeleteUser() {
		UsersDAOImpl usersDAO = new UsersDAOImpl();
		usersDAO.setSessionFactory(sessionFactory);
		usersDAO.deleteUser(4);
		sessionFactory.close();
	}

	private void testServiceGetContacts() throws JsonGenerationException, JsonMappingException, IOException {
		ContactsDAOImpl contactsDAO = new ContactsDAOImpl();
		contactsDAO.setSessionFactory(sessionFactory);
		UserService userService = new UserService();
		userService.setContactsDAO(contactsDAO);
		System.out.println(userService.getContacts());
	}
}
