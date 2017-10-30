package com.suggestion.daointerface;

import java.util.ArrayList;

import com.suggestion.model.User;

public interface UserInterface {
	boolean addUser(User user);
	User getUser(int userid);
	ArrayList<User> getUser(User user);
	int deleteUser(int userid);
	boolean updateUser(User user);
	int getUser(String username,String password);
}
