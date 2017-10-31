package com.suggestion.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
//import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.suggestion.dao.UserDao;
import com.suggestion.model.User;



@RunWith(Parameterized.class)
public class UserDaoTest {
	//private int userid;
	private String username; // name of user
	private String userpassword;// password of user
	boolean output;
	//int output1;
	


	public UserDaoTest(String username, String userpassword, boolean output) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.output = output;
		//this.output1=output1;
		
	}
	@Parameters
	public static Collection testData() {
		Object[][] arobjs = new Object[][] { {"jayshree","123",true},
				{"Jaya", "delhi",true} };
		return Arrays.asList(arobjs);

	}
	User user = new User(username,userpassword);

	

	@Test
	public void testAddUser() {
		
		boolean actual = UserDao.addUser(user);

		System.out.println(actual);
		assertEquals(output,actual);
	}

	@Test
	public void testGetUserInt() throws IOException {
		
		//User actual=UserDao.getUser(userid);
		assertNotNull(UserDao.getUser(7));
	}

	@Test
	public void testGetUser() throws IOException, SQLException {
		assertNotNull(UserDao.getUser(9));
	}
//
//	@Test
//	public void testDeleteUser() {
//		
//		boolean actual = UserDao.deleteUser(1);
//
//		System.out.println(actual);
//		assertEquals(output,actual);
//		//assertEquals(output,actual);
//		//assertNotNull(UserDao.deleteUser(3));
//	}

//	@Test
//	public void testUpdateUser() {
//		
//		int userid=8;
//		assertNotNull(UserDao.updateUser(userid, username, userpassword));
//		//boolean actual= UserDao.updateUser(userId, username, userpassword);
//	    //assertEquals(output,actual);
//	}
}

