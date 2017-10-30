package com.suggestion.model;


/**
 * Admin is a class which  gets and sets users.
 * @author User
 *
 */


public class Admin {
	
	private int adminid;
	private String adminname;
	private String adminpassword;
	public Admin(int adminid, String adminname, String adminpassword) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	
	
	public Admin(String adminname, String adminpassword) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	public Admin() {
		super();
	}

	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	
	

}
