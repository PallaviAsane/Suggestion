package com.suggestion.model;

/**
 * PptResource is a class which sets and gets ppt files.
 * @author User
 * @version 1.0
 */
public class PptResource {
	public static final String TABLENAME = "PptResource";
	public static final String PPTID = "pptid";
	public static final String PPTNAME = "pptname";
	public static final String PPTCATEGORY = "pptcategory";
	public static final String PPTAUTHOR = "pptauthor";
	public static final String PPTSIZE = "pptsize";

	private int pptid;// id of PPT
	private String pptname;// Name of PPT
	private String pptcategory;// category of PPT
	private String pptauthor;// author of PPT
	private String pptsize;// size of PPT
	/**
	 * Default constructor
	 */
	public PptResource() {
		super();
	}
	/**
	 * @param pptname
	 * @param pptcategory
	 * @param pptauthor
	 * @param pptsize
	 */
	public PptResource(String pptname, String pptcategory, String pptauthor,
			String pptsize) {
		super();
		this.pptname = pptname;
		this.pptcategory = pptcategory;
		this.pptauthor = pptauthor;
		this.pptsize = pptsize;
	}
	/**
	 * @param pptid
	 * @param pptname
	 * @param pptcategory
	 * @param pptauthor
	 * @param pptsize
	 */
	public PptResource(int pptid, String pptname, String pptcategory,
			String pptauthor, String pptsize) {
		super();
		this.pptid = pptid;
		this.pptname = pptname;
		this.pptcategory = pptcategory;
		this.pptauthor = pptauthor;
		this.pptsize = pptsize;
	}
	/**
	 * @param pptid
	 */
	public PptResource(int pptid) {
		super();
		this.pptid = pptid;
	}
	public int getPptid() {
		return pptid;
	}
	public void setPptid(int pptid) {
		this.pptid = pptid;
	}
	public String getPptname() {
		return pptname;
	}
	public void setPptname(String pptname) {
		this.pptname = pptname;
	}
	public String getPptcategory() {
		return pptcategory;
	}
	public void setPptcategory(String pptcategory) {
		this.pptcategory = pptcategory;
	}
	public String getPptauthor() {
		return pptauthor;
	}
	public void setPptauthor(String pptauthor) {
		this.pptauthor = pptauthor;
	}
	public String getPptsize() {
		return pptsize;
	}
	public void setPptsize(String pptsize) {
		this.pptsize = pptsize;
	}
	@Override
	public String toString() {
		return "PptResource [pptid=" + pptid + ", pptname=" + pptname
				+ ", pptcategory=" + pptcategory + ", pptauthor=" + pptauthor
				+ ", pptsize=" + pptsize + "]";
	}
	
	

}
