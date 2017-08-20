package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.UsersDAO;
import entities.User;

public class UsersDAOImpl implements UsersDAO {
	protected SessionFactory sessionFactory;

	@Override
	public void createUser(String login, String pass, String mail) {
		User user = new User();
		user.setLogin(login);
		user.setPass(pass);
		user.setMail(mail);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<User> results = session.createNamedQuery("getUsers", User.class).list();

		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public void updateUser(Integer userId, String login, String pass, String mail) {
		User user = new User();
		user.setID(userId);
		user.setLogin(login);
		user.setPass(pass);
		user.setMail(mail);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(user);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = new User();
		user.setID(userId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(user);

		session.getTransaction().commit();
		session.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
