package com.suggestion.model;

/**
 * User is a class which  gets and sets users.
 * @author User
 *
 */

public class User {
	
	public static final String TABLENAME = "SuggestionUser";
	public static final String USERID = "userid";
	public static final String USERNAME = "username";
	public static final String USERPASSWORD = "userpassword";
	
	private int userid;
	private String username; // name of user
	private String userpassword;// password of user
	


	
	public User(int userid, String username, String userpassword) {
	super();
	this.userid = userid;
	this.username = username;
	this.userpassword = userpassword;
}

	public User(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}
	public User() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", userpassword=" + userpassword + "]";
	}
	

	
}// end of User class
