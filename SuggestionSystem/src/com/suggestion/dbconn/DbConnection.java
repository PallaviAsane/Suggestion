package com.suggestion.dbconn;

import static java.lang.System.out;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DbConnection {
	public static final Logger logger = Logger.getLogger(DbConnection.class);
	private static Connection conn;

	public static Connection getConnection() {
		try {
			if (conn != null) {
				if (!conn.isClosed()) {
					return conn;
				}

			}
			Properties prop = new Properties();
			String filePath = "com/suggestion/dbconn/db.properties";
			
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
			prop.load(resourceAsStream);
//			File curDir = new File(".");
//			for ( String aFile : curDir.list())
//				logger.debug(aFile + "\n");
			
//			
			
//			FileReader dbProperties = new FileReader(filePath);
//			prop.load(dbProperties);
			
			String dbDriver = prop.getProperty("db.driver");
			String dbHost = prop.getProperty("db.host");
			String dbProtocol = prop.getProperty("db.protocol");
			String dbName = prop.getProperty("db.dbname");
			String dbPort = prop.getProperty("db.port");
			String dbUser = prop.getProperty("db.user");
			String dbPassword = prop.getProperty("db.password");

			Class.forName(dbDriver);
			String connstr = dbProtocol + "://" + dbHost + ":" + dbPort
					+ ";database=" + dbName + ";user=" + dbUser + ";password="
					+ dbPassword;
			conn = DriverManager.getConnection(connstr);
			logger.info(conn);
			return conn;
		}// try
		catch (Exception e) {
			logger.error(e);
		}// catch
		return conn;

	}

}
