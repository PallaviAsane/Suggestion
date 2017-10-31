package com.suggestion.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.suggestion.dao.PptResourceDao;
import com.suggestion.model.PptResource;



@RunWith(Parameterized.class)
public class PptResourceDaoTest {

	private String pptname;
	private String pptcategory;
	private String pptauthor;
	private String pptsize;
	boolean output;
	

	

	public PptResourceDaoTest(String pptname, String pptcategory,
			String pptauthor, String pptsize, boolean output) {
		super();
		this.pptname = pptname;
		this.pptcategory = pptcategory;
		this.pptauthor = pptauthor;
		this.pptsize = pptsize;
		this.output = output;
	}

	@Parameters
	public static Collection testData() {
		Object[][] arobjs = new Object[][] { {"java","java","jayu","20mb",true},
				{"java","java","jayshree","20mb",true} };
		return Arrays.asList(arobjs);

	}
	PptResource pptresource = new PptResource(pptname,pptcategory,pptauthor,pptsize);

	

	@Test
	public void testAddPptResource() {
		
		boolean actual = PptResourceDao.addPptResource(pptresource);

		System.out.println(actual);
		assertEquals(output,actual);
	}

//	@Test
//	public void testUpdatePptResource() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetAllPptResource() {
		assertNotNull(PptResourceDao.getAllPptResource(pptresource));
	}

	@Test
	public void testGetPptResource() {
		assertNotNull(PptResourceDao.getAllPptResource(pptresource));
	}
//	@Test
//	public void testGetsPptResource() {
//		assertNotNull(PptResourceDao.getPptResourcebyCategory("java"));
//	}
}
