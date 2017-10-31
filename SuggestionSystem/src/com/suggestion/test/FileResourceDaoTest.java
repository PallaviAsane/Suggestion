package com.suggestion.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.suggestion.dao.FileResourceDao;
import com.suggestion.model.FileResource;



@RunWith(Parameterized.class)
public class FileResourceDaoTest {
	
	private String filename;
	private String filecategory;
	private String fileauthor;
	private String filesize;
	boolean output;
	
	public FileResourceDaoTest(String filename, String filecategory,
			String fileauthor, String filesize, boolean output) {
		super();
		this.filename = filename;
		this.filecategory = filecategory;
		this.fileauthor = fileauthor;
		this.filesize = filesize;
		this.output = output;
	}

	@Parameters
	public static Collection testData() {
		Object[][] arobjs = new Object[][] { {"java","java","jayu","20mb",true},
				{"java","java","jayshree","20mb",true} };
		return Arrays.asList(arobjs);

	}
	FileResource fileresource = new FileResource(filename,filecategory,fileauthor,filesize);

	

	@Test
	public void testAddFileResource() {
		
		boolean actual = FileResourceDao.addFileResource(fileresource);

		System.out.println(actual);
		assertEquals(output,actual);
	}

	@Test
	public void testUpdateFileResource() {
		
		assertNotNull(FileResourceDao.updateFileResource(fileresource));
//		boolean actual = FileResourceDao.updateFileResource(fileresource);
//
//		System.out.println(actual);
//		assertEquals(output,actual);
	}

	@Test
	public void testGetAllFileResource() {
		assertNotNull(FileResourceDao.getAllFileResource(fileresource));
	}

	@Test
	public void testGetFileResource() {
		assertNotNull(FileResourceDao.addFileResource(fileresource));
	}

	@Test
	public void testGetFileResourcebyCategory() {
		assertNotNull(FileResourceDao.getFileResourcebyCategory("java"));
	}

}
