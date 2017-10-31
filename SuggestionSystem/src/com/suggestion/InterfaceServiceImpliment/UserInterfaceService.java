package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.UserDao;
import com.suggestion.daointerface.UserInterface;
import com.suggestion.model.User;
/**
 *  UserInterfaceService implements UserInterface to fetch UserDao class
 * @author User
 *
 */
public class UserInterfaceService implements UserInterface{

	/**
	 * addUser method calls UserDao to add user
	 * @return boolean result
	 */
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean adduser=UserDao.addUser(user);
		return adduser;
	}
	/**
	 * getUser method calls UserDao to get user
	 * @return user
	 */
	@Override
	public User getUser(int userid) {
		// TODO Auto-generated method stub
		User user=UserDao.getUser(userid);
		return user;
	}
	/**
	 * getUser method calls UserDao to gets all user
	 * @return list of users
	 */
	@Override
	public ArrayList<User> getUser(User user) {
		// TODO Auto-generated method stub
		ArrayList<User> listuser=UserDao.getUser(user);
		return listuser;
	}
	/**
	 * deleteUser method calls UserDao to delete user 
	 * @return users
	 */
	@Override
	public int deleteUser(int userid) {
		// TODO Auto-generated method stub
		int delete=UserDao.deleteUser(userid);
		return delete;
	}
	/**
	 * updateUser method calls UserDao to update user 
	 * @return users
	 */
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean update=UserDao.updateUser(user);
		return update;
	}
	/**
	 * getUser method calls UserDao to get user 
	 * @return user
	 */
	@Override
	public int getUser(String username, String password) {
		// TODO Auto-generated method stub
		int getuser=UserDao.getUser(username, password);
		return getuser;
	}

}
