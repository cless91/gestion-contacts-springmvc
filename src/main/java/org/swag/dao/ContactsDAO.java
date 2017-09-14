package org.swag.dao;

import java.util.List;

import org.swag.entities.Contact;

public interface ContactsDAO {
	public void createContact(Integer userId, String nom, String prenom, String mail, String telephone);

	public List<Contact> getContactsByUserId(Integer userId);

	public List<Contact> getContacts();

	public void updateContact(Integer userId, Integer contactId, String nom, String prenom, String mail,
			String telephone);

	public void deleteContact(Integer contactId);
}
