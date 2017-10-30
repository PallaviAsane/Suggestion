package com.suggestion.daointerface;

import java.util.List;

import com.suggestion.model.User;

public interface UserInterface {
	boolean addUser(User user);
	User getUser(int userid);
	List<User> getUser(User user);
	int deleteUser(int userid);
	boolean updateUser(User user);
}
