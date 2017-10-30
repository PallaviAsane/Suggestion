package com.suggestion.model;

public class Suggestion {

	public static final String TABLENAME = "Cookies";
	public static final String COOKIEID = "cookieid";
	public static final String COOKIENAME = "cookiename";
	public static final String USERID = "userid";
	
	
	private int cookieid; // name of user
	private String cookiename;// password of user
	private int userid;
	
	public Suggestion(int cookieid, String cookiename, int userid) {
		super();
		this.cookieid = cookieid;
		this.cookiename = cookiename;
		this.userid = userid;
	}
	
	public Suggestion(String cookiename, int userid) {
		super();
		this.cookiename = cookiename;
		this.userid = userid;
	}

	public Suggestion() {
		super();
	}

	public int getCookieid() {
		return cookieid;
	}
	public void setCookieid(int cookieid) {
		this.cookieid = cookieid;
	}
	public String getCookiename() {
		return cookiename;
	}
	public void setCookiename(String cookiename) {
		this.cookiename = cookiename;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
