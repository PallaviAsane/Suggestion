package com.suggestion.dao;

import static com.suggestion.model.Cookies.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.Cookies;

	/**
	 * FileResourceDao is class to communicate with database and perform operations as insert,update,select,delete
	 * @author User
	 */
	public class CookiesDao {
		public static final Logger logger = Logger.getLogger(CookiesDao.class);
		private static Connection connection=DbConnection.getConnection();
		
		private static String addQuery = "Insert into  " + TABLENAME
				+ "  values  (?,?,?) ";

		static String getFileQuery = "Select * from " + TABLENAME + " where "
				+ COOKIEID + "=(?)";

		private static String getFilesQuery = "Select * from " + TABLENAME;

		private static String updateFileQuery = "update " + TABLENAME + " set "
				+ COOKIENAME + "=? "  + " where " + COOKIEID + "=?";

		public static boolean addCookies(Cookies cookies)  {
		
			try {
				PreparedStatement statement = connection.prepareStatement(addQuery);
				
				int cookieid = cookies.getCookieid();
				String cookiename = cookies.getCookiename();
				int userid = cookies.getUserid();
				
				
				statement.setInt(1, cookieid);
				statement.setString(2, cookiename);
				statement.setInt(3, userid);
				
				int i = statement.executeUpdate();
				if (i > 0) {
					return true;
				} else
				{
					
					return false;
				}
			} catch (Exception e) {
				logger.error(e);
			}
			return false;
		}

		public static boolean updateCookies(Cookies cookies) {
			try {
				PreparedStatement statement = connection.prepareStatement(updateFileQuery);
//				int cookieid = cookies.getCookieid();
				String cookiename = cookies.getCookiename();
				int userid = cookies.getUserid();
				
				
				statement.setString(1, cookiename);
				statement.setInt(2, userid);
				
				int i = statement.executeUpdate();
				if (i > 0) {
					logger.info(i + " values updated");
					return true;
				} else {
					logger.info("not updated");
					return false;
				}
			} catch (Exception e) {
				logger.error(e);
			}
			return false;
		}
		
		public static ArrayList<Cookies> getsCookies(Cookies cookies) {
			ArrayList<Cookies> fileresourcelist=new ArrayList<Cookies>();
			try{
				PreparedStatement statement=connection.prepareStatement(getFilesQuery);
				ResultSet resultset=statement.executeQuery();
				while(resultset.next())
				{
					int cookieid=resultset.getInt(1);
					String cookiesname=resultset.getString(2);
					int userid=resultset.getInt(3);
					
					
					cookies=new Cookies(cookieid,cookiesname,userid);
					fileresourcelist.add(cookies);
				}
				
			}catch(Exception e){System.out.println(e);}
			return fileresourcelist;
		}
		
		public static Cookies getCookies(int fileid) {
			Cookies cookies=new Cookies();
			try{
				PreparedStatement statement=connection.prepareStatement(getFileQuery);
				statement.setLong(1, fileid);
				ResultSet resulset=statement.executeQuery();
				while(resulset.next())
				{
					int cookieid=resulset.getInt(1);
					String cookiesname=resulset.getString(2);
					int userid=resulset.getInt(3);
					
					
					cookies=new Cookies(cookieid,cookiesname,userid);
				}
				
			}catch(Exception e){System.out.println(e);}
			return cookies;
		}
	
	
}
