package com.suggestion.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.Admin;

 
public class AdminDao {
	
	private static Connection conn =DbConnection.getConnection();
	private static String addQuery = "insert into Admin values(?,?)";
	private static String deleteQuery = "delete from Admin where adminid = ?";
	private static String getOneQuery = "select * from Admin where adminid = ?";
	private static String getAllQuery = "select * from Admin";
	private static String updateQuery = "update Admin set  adminname = ?, where adminid = ?";
	
	public static int addAdmin(Admin admin){
		
		try {
			PreparedStatement statement = conn.prepareStatement(addQuery);
			//statement.setInt(1, admin.getAdminid());
			statement.setString(1, admin.getAdminname());
			statement.setString(2, admin.getAdminpassword());
			

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0)
				return 1;

		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return 0;
	}// add User method

	/**
	 * 
	 * @author User
	 * @param id,username,password,type
	 * @method getUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	
	public static Admin getAdmin(int adminid)  {
		//conn = DBConnection.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(getOneQuery);
			statement.setInt(1, adminid);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				int adminId = resultset.getInt(1);
				String adminname = resultset.getString(2);
				String adminpassword = resultset.getString(3);

				//String userpassword;
				Admin admin = new Admin(adminId, adminname, adminpassword);
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}// get a User method

	/**
	 * 
	 * @author User
	 * @param id,username,password,type
	 * @method AllgetUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static List<Admin> getAdmin()  {
		//conn = DBConnection.getConnection();
		

		Admin admin = null;
		List<Admin> listOfproducts = new ArrayList<Admin>();

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAllQuery);
			while (resultSet.next()) {
				//User user = new User();
				int adminId = resultSet.getInt(1);
				String adminname = resultSet.getString(2);
                String adminpassword = resultSet.getString(3);

				admin.setAdminid(adminId);
				admin.setAdminname(adminname);
				admin.setAdminpassword(adminpassword);

				listOfproducts.add(admin);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfproducts;

	}// get all User method
	/**
	 * 
	 * @author User
	 * @param id,username,password,type
	 * @method delettUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static int deleteUser(int adminId)  {
		//conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(deleteQuery);
			statement.setInt(1, adminId);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 1)
				return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}// delete User method
	/**
	 * 
	 * @author User
	 * @param id,username,password,type
	 * @method updateUser
	 * @return User
	 * @throws IOException
	 * 
	 *
	 */
	public static int updateAdmin(int userId, String username,String password)  {
		//conn= DBConnection.getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(updateQuery);
			statement.setInt(1, userId);
			statement.setString(2, username);
			
			statement.setString(4, password);

			int resultUpdate = statement.executeUpdate();

			if (resultUpdate == 1)
				return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}//update user method
	

	
	
	
}
