package com.suggestion.InterfaceServiceImpliment;

import java.util.List;

import com.suggestion.dao.UserDao;
import com.suggestion.daointerface.UserInterface;
import com.suggestion.model.User;

public class UserInterfaceService implements UserInterface{

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean adduser=UserDao.addUser(user);
		return adduser;
	}

	@Override
	public User getUser(int userid) {
		// TODO Auto-generated method stub
		User user=UserDao.getUser(userid);
		return user;
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		List<User> listuser=UserDao.getUser(user);
		return listuser;
	}

	@Override
	public int deleteUser(int userid) {
		// TODO Auto-generated method stub
		int delete=UserDao.deleteUser(userid);
		return delete;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean update=UserDao.updateUser(user);
		return update;
	}

}
