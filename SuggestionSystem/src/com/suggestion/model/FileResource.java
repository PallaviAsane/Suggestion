package com.suggestion.model;

/**
 * FileResorce is a class which sets and gets text files.
 * @author User
 * @version 1.0
 *
 */
public class FileResource {
	public static final String TABLENAME = "FileResource";
	public static final String FILEID = "fileid";
	public static final String FILENAME = "filename";
	public static final String FILECATEGORY = "filecategory";
	public static final String FILEAUTHOR = "fileauthor";
	public static final String FILESIZE = "filesize";

	private int fileid;// id of file
	private String filename;// Name of file
	private String filecategory;// category of file
	private String fileauthor;// author of file
	private String filesize;// size of file
	
	
	/**
	 * Default constructor
	 */
	public FileResource() {
		super();
	}
	
	
	
	/**
	 * @param fileid
	 * @param filename
	 * @param filecategory
	 * @param fileauthor
	 * @param filesize
	 */
	public FileResource(int fileid, String filename, String filecategory,
			String fileauthor, String filesize) {
		super();
		this.fileid = fileid;
		this.filename = filename;
		this.filecategory = filecategory;
		this.fileauthor = fileauthor;
		this.filesize = filesize;
	}



	/**
	 * Parameterized constructor with all parameter
	 *
	 * @param filename
	 * @param filecategory
	 * @param fileauthor
	 * @param filesize
	 */
	public FileResource(String filename, String filecategory,
			String fileauthor, String filesize) {
		super();
		
		this.filename = filename;
		this.filecategory = filecategory;
		this.fileauthor = fileauthor;
		this.filesize = filesize;
	}
	/**
	 * parameterized constructor with file id as parameter
	 * @param fileid
	 */
	public FileResource(int fileid) {
		super();
		this.fileid = fileid;
	}
	
	
	
	/**
	 * parameterized constructor with file category as parameter
	 * @param filecategory
	 */
	public FileResource(String filecategory) {
		super();
		this.filecategory = filecategory;
	}



	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilecategory() {
		return filecategory;
	}
	public void setFilecategory(String filecategory) {
		this.filecategory = filecategory;
	}
	public String getFileauthor() {
		return fileauthor;
	}
	public void setFileauthor(String fileauthor) {
		this.fileauthor = fileauthor;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	
	
	@Override
	public String toString() {
		return "FileResource [fileid=" + fileid + ", filename=" + filename
				+ ", filecategory=" + filecategory + ", fileauthor="
				+ fileauthor + ", filesize=" + filesize + "]";
	}//end of toString
	
	
	
	

}
