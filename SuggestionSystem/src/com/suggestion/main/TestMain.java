package com.suggestion.main;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.suggestion.InterfaceServiceImpliment.CookiesServiceImplement;
import com.suggestion.InterfaceServiceImpliment.FileResourceInterfaceService;
import com.suggestion.InterfaceServiceImpliment.PptResourceInterfaceService;
import com.suggestion.dao.FileResourceDao;
import com.suggestion.dbconn.DbConnection;
import com.suggestion.model.Cookies;
import com.suggestion.model.FileResource;
import com.suggestion.model.PptResource;

public class TestMain {
public static final Logger logger=Logger.getLogger(TestMain.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getConnection();
		logger.info(conn);
//		FileResource fr=new FileResource("phpfile","php","jayashri","120MB");
//		boolean add=FileResourceDao.addFileResource(fr);
//		boolean add=FileResourceDao.updateFileResource(fr);
//		logger.info(add);
		
//		FileResource fr1=FileResourceDao.getFileResource(1);
//		logger.info(fr1);
		
//		FileResource fr2=new FileResource();
//		FileResourceInterfaceService fri=new FileResourceInterfaceService();
////		ArrayList<FileResource> frlist=FileResourceDao.getAllFileResource(fr2);
//		ArrayList<FileResource> frlist=fri.getAllFileResource(fr2);
//		System.out.println(frlist);
//		PptResourceInterfaceService ser=new PptResourceInterfaceService();
//		PptResource pptres=new PptResource("phpppt","php","Jayashri","12kb");
//		boolean res=ser.addPptResource(pptres);
//		logger.info(res);
		
//		FileResourceInterfaceService fr=new FileResourceInterfaceService();
//		ArrayList<FileResource> file=fr.getFileResourcebyCategory("php");
//		logger.info(file);
		
		CookiesServiceImplement co=new CookiesServiceImplement();
		Cookies ck=new Cookies(1,"kit",1);
		boolean add=co.addCookies(ck);
		logger.info(add);
	}

}
