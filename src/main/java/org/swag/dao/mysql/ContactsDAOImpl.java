package org.swag.dao.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swag.dao.ContactsDAO;
import org.swag.entities.Contact;

@Component
public class ContactsDAOImpl implements ContactsDAO {

	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createContact(Integer userId, String nom, String prenom, String mail, String telephone) {
		Contact contact = new Contact();
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setMail(mail);
		contact.setTelephone(telephone);
		contact.setUserId(userId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(contact);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Contact> getContactsByUserId(Integer userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Contact> results = session.createNamedQuery("getContacts", Contact.class).list();

		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public void updateContact(Integer userId, Integer contactId, String nom, String prenom, String mail,
			String telephone) {
		Contact contact = new Contact();
		contact.setUserId(userId);
		contact.setID(contactId);
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setMail(mail);
		contact.setTelephone(telephone);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(contact);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void deleteContact(Integer contactId) {
		Contact contact = new Contact();
		contact.setID(contactId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(contact);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Contact> getContacts() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Contact> results = session.createNamedQuery("getContacts", Contact.class).list();

		session.getTransaction().commit();
		session.close();

		return results;

	}

}
