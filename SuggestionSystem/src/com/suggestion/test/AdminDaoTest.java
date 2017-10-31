package com.suggestion.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.suggestion.dao.AdminDao;
import com.suggestion.model.Admin;


@RunWith(Parameterized.class)
public class AdminDaoTest {

	private String adminname; // name of user
	private String adminpassword;// password of user
	boolean output;

	public AdminDaoTest(String adminname, String adminpassword, boolean output) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
		this.output = output;
	}
	@Parameters
	public static Collection testData() {
		Object[][] arobjs = new Object[][] { {"Admin","123",true},{"Jaya", "delhi",true }};
		return Arrays.asList(arobjs);

	}
	Admin admin = new Admin(adminname,adminpassword);

	@Test
	public void testAddAdmin() {
		
		//Admin admin = null;
		int actual = AdminDao.addAdmin(admin);
		System.out.println(actual);
		assertEquals(output,actual);
	}

//	@Test
//	public void testGetAdminInt() {
//		assertNotNull(AdminDao.addAdmin(admin));
//	}

	
}
