package com.suggestion.dao;

import static com.suggestion.model.PdfResource.*;

import java.sql.*;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.suggestion.dbconn.DbConnection;
//import static com.dto.PdfResource.*;
import com.suggestion.model.PdfResource;
//import java.io.IOException;

/**
 * FileResourceDao is class to communicate with database and perform operations as insert,update,select,delete
 * @author User
 */

public class PdfResourceDao {
	public static final Logger logger = Logger.getLogger(PdfResourceDao.class);
	private static Connection connection = DbConnection.getConnection();
	
	private static String addQuery = "Insert into " + TABLENAME+ " values (?,?,?,?)";

	static String getFileQuery = "Select * from " + TABLENAME + " where "+ PDFID + "=(?)";
	
	static String getsFileQuery = "Select * from " + TABLENAME + " where "+ PDFCATEGORY + "=(?)";

	private static String getFilesQuery = "Select * from " + TABLENAME;

	private static String updateFileQuery = "update " + TABLENAME + " set "
			+ PDFNAME + "=? " + "," + PDFCATEGORY + "=? " + "," + PDFAUTHOR
			+ "=? " + "," + PDFSIZE + "=? " + " where " + PDFID + "=?";

	
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
	public static boolean addPdfResource(PdfResource pdfresource) {
		try {
			PreparedStatement satement = connection.prepareStatement(addQuery);
			String pdfname =  pdfresource.getPdfname();
			String pdfcategory =  pdfresource.getPdfcategory();
			String pdfauthor =  pdfresource.getPdfauthor();
			String pdfsize =  pdfresource.getPdfsize();
			
			satement.setString(1, pdfname);
			satement.setString(2, pdfcategory);
			satement.setString(3, pdfauthor);
			satement.setString(4, pdfsize);
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
	public static boolean updatePdfResource(PdfResource pdfresource) {
		try {
			PreparedStatement statement = connection.prepareStatement(updateFileQuery);
			int pdfid=pdfresource.getPdfid();
			String pdfname = pdfresource.getPdfname();
			String pdfcategory = pdfresource.getPdfcategory();
			String pdfauthor = pdfresource.getPdfauthor();
			String pdfsize = pdfresource.getPdfsize();
			
			statement.setString(1, pdfname);
			statement.setString(2, pdfcategory);
			statement.setString(3, pdfauthor);
			statement.setString(4, pdfsize);
			statement.setInt(5, pdfid);
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
	public static ArrayList<PdfResource> getAllPdfResource(PdfResource pdfresource) {
		ArrayList<PdfResource> fileresourcelist=new ArrayList<PdfResource>();
		try{
			PreparedStatement statement=connection.prepareStatement(getFilesQuery);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pdfid=resultset.getInt(1);
				String pdfname=resultset.getString(2);
				String pdfcategory=resultset.getString(3);
				String pdfauthor=resultset.getString(4);
				String pdfsize=resultset.getString(5);
				
				pdfresource=new PdfResource(pdfid,pdfname,pdfcategory,pdfauthor,pdfsize);
				 fileresourcelist.add(pdfresource);
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
	 * @return
	 */
	
	public static PdfResource getPdfResource(int pdfid) {
		PdfResource pdfresource=new PdfResource();
		try{
			PreparedStatement statement=connection.prepareStatement(getFileQuery);
			statement.setLong(1,pdfid);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pdfId=resultset.getInt(1);
				String pdfname=resultset.getString(2);
				String pdfcategory=resultset.getString(3);
				String pdfauthor=resultset.getString(4);
				String pdfsize=resultset.getString(5);
				pdfresource=new PdfResource(pdfId,pdfname,pdfcategory,pdfauthor,pdfsize);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return pdfresource;
	}// method getFileResource
	public static PdfResource getsPdfResource(String category) {
		PdfResource pdfresource=new PdfResource();
		try{
			PreparedStatement statement=connection.prepareStatement(getsFileQuery);
			statement.setString(1,category);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pdfId=resultset.getInt(1);
				String pdfname=resultset.getString(2);
				String pdfcategory=resultset.getString(3);
				String pdfauthor=resultset.getString(4);
				String pdfsize=resultset.getString(5);
				pdfresource=new PdfResource(pdfId,pdfname,pdfcategory,pdfauthor,pdfsize);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return pdfresource;
	}// method getFileResource
}
