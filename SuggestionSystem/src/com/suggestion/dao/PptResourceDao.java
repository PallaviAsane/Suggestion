package com.suggestion.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.PptResource;
import static com.suggestion.model.PptResource.*;
/**
 * PptResourceDao is class to communicate with database and perform operations as insert,update,select,delete
 * @author User
 */
public class PptResourceDao {
	public static final Logger logger = Logger.getLogger(PptResourceDao.class);
	private static Connection connection = DbConnection.getConnection();
	private static String addQuery = "Insert into " + TABLENAME
			+ " values (?,?,?,?)";

	static String getpptQuery = "Select * from " + TABLENAME + " where "
			+ PPTID + "=(?)";

	private static String getpptsQuery = "Select * from " + TABLENAME;

	private static String updatepptQuery = "update " + TABLENAME + " set "
			+ PPTNAME + "=? " + "," + PPTCATEGORY + "=? " + "," + PPTAUTHOR
			+ "=? " + "," + PPTSIZE + "=? " + " where " + PPTID + "=?";

	private static String getpptByCategory="Select * from " + TABLENAME + " where "
			+ PPTCATEGORY + " = ? ";
	/**
	 * addPptResource method for insert data into database table
	 *
	 * @param pptresurce  PptResorce reference variable
	 * @param satement object of prepared statement
	 * @param pptname set name of PPT
	 * @param pptcategory set category of PPT
	 * @param pptauthor set author of PPT
	 * @param pptsize set size of PPT
	 * @param add how much rows added into database table
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return  boolean as a result
	 */
	public static boolean addPptResource(PptResource pptresurce) {
		try {
			PreparedStatement satement = connection.prepareStatement(addQuery);
			String pptname = pptresurce.getPptname();
			String pptcategory = pptresurce.getPptcategory();
			String pptauthor = pptresurce.getPptauthor();
			String pptsize = pptresurce.getPptsize();
			satement.setString(1, pptname);
			satement.setString(2, pptcategory);
			satement.setString(3, pptauthor);
			satement.setString(4, pptsize);
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
	}// addPptResource method

	/**
	 * updatePptResource method update the data in database table
	 * @param pptresurce PptResorce reference variable
	 * @param statement object of prepared statement
	 * @param pptid update according to PPT id
	 * @param pptname update name of PPT
	 * @param pptcategory update category of PPT
	 * @param pptauthor update author of PPT
	 * @param pptsize update size of PPT
	 * @param update how much rows update into database table
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return boolean result
	 */
	public static boolean updatePptResource(PptResource pptresurce) {
		try {
			PreparedStatement statement = connection.prepareStatement(updatepptQuery);
			int pptid=pptresurce.getPptid();
			String pptname = pptresurce.getPptname();
			String pptcategory = pptresurce.getPptcategory();
			String pptauthor = pptresurce.getPptauthor();
			String pptsize = pptresurce.getPptsize();
			statement.setString(1, pptname);
			statement.setString(2, pptcategory);
			statement.setString(3, pptauthor);
			statement.setString(4, pptsize);
			statement.setInt(5, pptid);
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
	}// method updatePptResource
	
	/**
	 * getAllPptResource method get all list of PPT resource
	 * @param pptreource FileResorce reference variable
	 * @param statement Prepared statement object
	 * @param pptid select PPT id
	 * @param pptname select name of PPT
	 * @param pptcategory select category of PPT
	 * @param pptauthor select author of PPT
	 * @param pptsize select size of PPT
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return Array list of PPT resource
	 */
	public static ArrayList<PptResource> getAllPptResource(PptResource pptreource) {
		ArrayList<PptResource> pptresourcelist=new ArrayList<PptResource>();
		try{
			PreparedStatement statement=connection.prepareStatement(getpptsQuery);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pptid=resultset.getInt(1);
				String pptname=resultset.getString(2);
				String pptcategory=resultset.getString(3);
				String pptauthor=resultset.getString(4);
				String pptsize=resultset.getString(5);
				
				pptreource=new PptResource(pptid,pptname,pptcategory,pptauthor,pptsize);
				pptresourcelist.add(pptreource);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return pptresourcelist;
	}// method getAllPptResource
	
	/**
	 * getPptResource method get PPT resource from database according to id 
	 * @param pptid get PPT according to id
	 * @param statement Prepared statement object
	 * @param pptid select PPT id
	 * @param pptname select name of PPT
	 * @param pptcategory select category of PPT
	 * @param pptauthor select author of PPT
	 * @param pptsize select size of PPT
	 * @throws NullPointerException
	 * @throws SQLException
	 * @return PptResource as a result
	 */
	
	public static PptResource getPptResource(int pptid) {
		PptResource pptresource=new PptResource();
		try{
			PreparedStatement statement=connection.prepareStatement(getpptQuery);
			statement.setLong(1, pptid);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pptId=resultset.getInt(1);
				String pptname=resultset.getString(2);
				String pptcategory=resultset.getString(3);
				String pptauthor=resultset.getString(4);
				String pptsize=resultset.getString(5);
				pptresource=new PptResource(pptId,pptname,pptcategory,pptauthor,pptsize);
			}//while
			
		}//try
		catch (NullPointerException nullpntexp) {
			logger.error(nullpntexp);
		}// catch
		catch(SQLException sqlexp){
			logger.error(sqlexp);
		}//catch
		return pptresource;
	}// method getPptResource
	
	
	/**
	 * getFileResourcebyCategory method get file resource by category from database 
	 * @param Category
	 * @return FileResource
	 */
	public static ArrayList<PptResource> getPptResourcebyCategory(String Category) {
		PptResource pptresource=new PptResource();
		ArrayList<PptResource> listbycategory=new ArrayList<PptResource>();
		try{
			PreparedStatement statement=connection.prepareStatement(getpptByCategory);
//			logger.debug(statement);
			statement.setString(1,Category);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int pptid=resultset.getInt(1);
				String pptname=resultset.getString(2);
				String pptcategory=resultset.getString(3);
				String pptauthor=resultset.getString(4);
				String pptsize=resultset.getString(5);
				pptresource=new PptResource(pptid,pptname,pptcategory,pptauthor,pptsize);
				listbycategory.add(pptresource);
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
