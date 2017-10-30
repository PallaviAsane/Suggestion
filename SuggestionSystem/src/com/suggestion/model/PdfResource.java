package com.suggestion.model;

public class PdfResource {
	
	public static final String TABLENAME = "PdfResource";
	public static final String PDFID = "pdfid";
	public static final String PDFNAME = "pdfname";
	public static final String PDFCATEGORY = "pdfcategory";
	public static final String PDFAUTHOR = "pdfauthor";
	public static final String PDFSIZE = "pdfsize";
	
	
	private int pdfid;
	private String pdfname;
	private String pdfcategory;
	private String pdfauthor;
	private String pdfsize;
	public PdfResource(int pdfid, String pdfname, String pdfcategory,
			String pdfauthor, String pdfsize) {
		super();
		this.pdfid = pdfid;
		this.pdfname = pdfname;
		this.pdfcategory = pdfcategory;
		this.pdfauthor = pdfauthor;
		this.pdfsize = pdfsize;
	}
	
	
	public PdfResource(String pdfname, String pdfcategory, String pdfauthor,
			String pdfsize) {
		super();
		this.pdfname = pdfname;
		this.pdfcategory = pdfcategory;
		this.pdfauthor = pdfauthor;
		this.pdfsize = pdfsize;
	}


	public PdfResource() {
		super();
	}


	public int getPdfid() {
		return pdfid;
	}
	public void setPdfid(int pdfid) {
		this.pdfid = pdfid;
	}
	public String getPdfname() {
		return pdfname;
	}
	public void setPdfname(String pdfname) {
		this.pdfname = pdfname;
	}
	public String getPdfcategory() {
		return pdfcategory;
	}
	public void setPdfcategory(String pdfcategory) {
		this.pdfcategory = pdfcategory;
	}
	public String getPdfauthor() {
		return pdfauthor;
	}
	public void setPdfauthor(String pdfauthor) {
		this.pdfauthor = pdfauthor;
	}
	public String getPdfsize() {
		return pdfsize;
	}
	public void setPdfsize(String pdfsize) {
		this.pdfsize = pdfsize;
	}
	
	
	
	
	
	
}
