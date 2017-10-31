package com.suggestion.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.suggestion.dao.PdfResourceDao;
import com.suggestion.model.PdfResource;



@RunWith(Parameterized.class)
public class PdfResourceDaoTest {

	private String pdfname;
	private String pdfcategory;
	private String pdfauthor;
	private String pdfsize;
	boolean output;
	
	

	public PdfResourceDaoTest(String pdfname, String pdfcategory,
			String pdfauthor, String pdfsize, boolean output) {
		super();
		this.pdfname = pdfname;
		this.pdfcategory = pdfcategory;
		this.pdfauthor = pdfauthor;
		this.pdfsize = pdfsize;
		this.output = output;
	}

	@Parameters
	public static Collection testData() {
		Object[][] arobjs = new Object[][] { {"java","java","jayu","20mb",true},
				{"java","java","jayshree","20mb",true} };
		return Arrays.asList(arobjs);

	}
	PdfResource pdfresource = new PdfResource(pdfname,pdfcategory,pdfauthor,pdfsize);

	

	@Test
	public void testAddFileResource() {
		
		boolean actual = PdfResourceDao.addPdfResource(pdfresource);

		System.out.println(actual);
		assertEquals(output,actual);
	}

//	@Test
//	public void testUpdatePdfResource() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testGetAllPdfResource() {
		assertNotNull(PdfResourceDao.getAllPdfResource(pdfresource));
	}

	@Test
	public void testGetPdfResource() {
		assertNotNull(PdfResourceDao.getPdfResource(6));
	}

	@Test
	public void testGetsPdfResource() {
		assertNotNull(PdfResourceDao.getsPdfResource("java"));
	}

}
