package com.suggestion.dao;

//import com.dto.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.User;
import static com.suggestion.model.User.*;

/**
 * UserDao is a class which is connected with database and performing
 * select,insert,update and delet operations.
 * 
 * @author User
 *
 */

public class UserDao {

	public static final Logger logger = Logger.getLogger(UserDao.class);
	private static Connection connection = DbConnection.getConnection();
	private static String addQuery = "insert into " + TABLENAME
			+ " values (?,?)";
	private static String deleteQuery = "delete from " + TABLENAME + " where "
			+ USERID + "=?";
	private static String getOneQuery = "select * from " + TABLENAME
			+ " where " + USERID + "= ?";
	private static String getAllQuery = "select * from " + TABLENAME;
	private static String updateQuery = "update " + TABLENAME + " set "
			+ USERNAME + "=?" + USERPASSWORD + "=?" + " where " + USERID
			+ " = ?";
	private static String getuserQuery = "select * from " + TABLENAME
			+ " where " + USERNAME + "= ? AND " + USERPASSWORD + " = ?";

	/**
	 * 
	 * @author User
	 * @param id
	 *            ,username,password
	 * @method addUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static boolean addUser(User user) {

		try {
			PreparedStatement statement = connection.prepareStatement(addQuery);
			// statement.setInt(1, user.getUserid());
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getUserpassword());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				return true;
			}// if

			else

			{
				return false;
			}// else

		}// try

		catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}// catch

		return false;
	}// add User method

	/**
	 * 
	 * @author User
	 * @param id
	 *            ,username,password
	 * @method getUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */

	public static User getUser(int userid) {
		// conn = DBConnection.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(getOneQuery);
			statement.setInt(1, userid);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				// int userId = resultset.getInt(1);
				String userName = resultset.getString(1);
				String userpassword = resultset.getString(2);

				// String userpassword;
				User user = new User(userName, userpassword);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return null;
	}// get a User method

	/**
	 * 
	 * @author User
	 * @param id
	 *            ,username,password,type
	 * @method AllgetUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static ArrayList<User> getUser(User user) {
		// conn = DBConnection.getConnection();
		ArrayList<User> listOfproducts = new ArrayList<User>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getAllQuery);
			while (resultSet.next()) {
				// User user = new User();
				int userid = resultSet.getInt(1);
				String username = resultSet.getString(2);
				String userpassword = resultSet.getString(3);

				user.setUserid(userid);
				user.setUsername(username);
				user.setUserpassword(userpassword);

				listOfproducts.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}

		return listOfproducts;

	}// get all User method

	/**
	 * 
	 * @author User
	 * @param id
	 *            ,username,password,type
	 * @method delettUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static int deleteUser(int userid) {
		// conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, userid);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 1)
				return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		}
		return 0;
	}// delete User method

	/**
	 * 
	 * @author User
	 * @param id
	 *            ,username,password
	 * @method updateUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static boolean updateUser(User user) {
		// conn= DBConnection.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getUserpassword());
			statement.setInt(3, user.getUserid());

			int resultUpdate = statement.executeUpdate();

			if (resultUpdate > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return false;
	}// update user method

	public static int getUser(String username, String password) {
		// conn= DBConnection.getConnection();
		int userid=0;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(getuserQuery);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				 userid = resultset.getInt(1);
			}
			return userid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return userid;
	}// update user method

}
