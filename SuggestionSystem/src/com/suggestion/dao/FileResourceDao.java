package com.suggestion.dao;

import static com.suggestion.model.FileResource.*;

import java.sql.*;
import java.util.ArrayList;

//import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.FileResource;
/**
 * FileResourceDao is class to communicate with database and perform operations as insert,update,select,delete
 * @author User
 */
public class FileResourceDao {
	public static final Logger logger = Logger.getLogger(FileResourceDao.class);
	private static Connection connection = DbConnection.getConnection();
	private static String addQuery = "Insert into " + TABLENAME
			+ " values (?,?,?,?)";

	static String getFileQuery = "Select * from " + TABLENAME + " where "
			+ FILEID + "=(?)";

	private static String getFilesQuery = "Select * from " + TABLENAME;

	private static String updateFileQuery = "update " + TABLENAME + " set "
			+ FILENAME + "=? " + "," + FILECATEGORY + "=? " + "," + FILEAUTHOR
			+ "=? " + "," + FILESIZE + "=? " + " where " + FILEID + "=?";
	
	private static String getFileByCategory="Select * from " + TABLENAME + " where "
			+ FILECATEGORY + " = ? ";

	
	/**
	 * addFileResource method for insert data into database table
	 *
	 * @param fileresurce  FileResorce reference variable
	 * @param satement object of prepared statement
	 * @param filename set name of file
	 * @param filecategory set category of file
	 * @param fileauthor set author of file
	 * @param filesize set size of file
	 * @param add how much rows added into database table
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return  boolean result
	 */
	public static boolean addFileResource(FileResource fileresurce) {
		try {
			PreparedStatement satement = connection.prepareStatement(addQuery);
			String filename = fileresurce.getFilename();
			String filecategory = fileresurce.getFilecategory();
			String fileauthor = fileresurce.getFileauthor();
			String filesize = fileresurce.getFilesize();
			satement.setString(1, filename);
			satement.setString(2, filecategory);
			satement.setString(3, fileauthor);
			satement.setString(4, filesize);
			int add = satement.executeUpdate();
			if (add > 0) {
				return true;
			}// end of if 
			else
				return false;
		}//try 
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return false;
	}// addFileResource method

	/**
	 * update the data in database table
	 * @param fileresurce FileResorce reference variable
	 * @param statement object of prepared statement
	 * @param fileid update according to file id
	 * @param filename update name of file
	 * @param filecategory update category of file
	 * @param fileauthor update author of file
	 * @param filesize update size of file
	 * @param update how much rows update into database table
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return boolean result
	 */
	public static boolean updateFileResource(FileResource fileresurce) {
		try {
			PreparedStatement statement = connection.prepareStatement(updateFileQuery);
			int fileid=fileresurce.getFileid();
			String filename = fileresurce.getFilename();
			String filecategory = fileresurce.getFilecategory();
			String fileauthor = fileresurce.getFileauthor();
			String filesize = fileresurce.getFilesize();
			statement.setString(1, filename);
			statement.setString(2, filecategory);
			statement.setString(3, fileauthor);
			statement.setString(4, filesize);
			statement.setInt(5, fileid);
			int update = statement.executeUpdate();
			if (update > 0) {
				logger.info(update + " values updated");
				return true;
			} //if
			else {
				logger.info("not updated");
				return false;
			}//else
		} //try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return false;
	}// method updateFileResource
	
	/**
	 * get all list of file resource
	 * @param filereource FileResorce reference variable
	 * @param statement Prepared statement object
	 * @param fileid select file id
	 * @param filename select name of file
	 * @param filecategory select category of file
	 * @param fileauthor select author of file
	 * @param filesize select size of file
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return Array list of file resource
	 */
	public static ArrayList<FileResource> getAllFileResource(FileResource filereource) {
		ArrayList<FileResource> fileresourcelist=new ArrayList<FileResource>();
		try{
			PreparedStatement statement=connection.prepareStatement(getFilesQuery);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int fileid=resultset.getInt(1);
				String filename=resultset.getString(2);
				String filecategory=resultset.getString(3);
				String fileauthor=resultset.getString(4);
				String filesize=resultset.getString(5);
				
				filereource=new FileResource(fileid,filename,filecategory,fileauthor,filesize);
				 fileresourcelist.add(filereource);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return fileresourcelist;
	}// method getAllFileResource
	
	/**
	 * get file resource from database according to id 
	 * @param fileid get file according to id
	 * @param statement Prepared statement object
	 * @param fileid select file id
	 * @param filename select name of file
	 * @param filecategory select category of file
	 * @param fileauthor select author of file
	 * @param filesize select size of file
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return FileResource
	 */
	
	public static FileResource getFileResource(int fileid) {
		FileResource fileresource=new FileResource();
		try{
			PreparedStatement statement=connection.prepareStatement(getFileQuery);
			statement.setLong(1, fileid);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int fileId=resultset.getInt(1);
				String filename=resultset.getString(2);
				String filecategory=resultset.getString(3);
				String fileauthor=resultset.getString(4);
				String filesize=resultset.getString(5);
				fileresource=new FileResource(fileId,filename,filecategory,fileauthor,filesize);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return fileresource;
	}// method getFileResource
	
	/**
	 * getFileResourcebyCategory method get file resource by category from database 
	 * @param Category
	 * @return FileResource
	 */
	public static ArrayList<FileResource> getFileResourcebyCategory(String Category) {
		FileResource fileresource=new FileResource();
		ArrayList<FileResource> listbycategory=new ArrayList<FileResource>();
		try{
			PreparedStatement statement=connection.prepareStatement(getFileByCategory);
//			logger.debug(statement);
			statement.setString(1,Category);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int fileId=resultset.getInt(1);
				String filename=resultset.getString(2);
				String filecategory=resultset.getString(3);
				String fileauthor=resultset.getString(4);
				String filesize=resultset.getString(5);
				fileresource=new FileResource(fileId,filename,filecategory,fileauthor,filesize);
				listbycategory.add(fileresource);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		
		return listbycategory;
	}// method getFileResourcebyCategory
}
