package dao;

import java.util.List;

import entities.User;

public interface UsersDAO {
	public void createUser(String login, String pass, String mail);

	public List<User> getUsers();

	public void updateUser(Integer userId, String login, String pass, String mail);

	public void deleteUser(Integer userId);
}
