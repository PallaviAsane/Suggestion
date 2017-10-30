/**
 * 
 */
package com.suggestion.daointerface;

import java.util.ArrayList;

import com.suggestion.model.FileResource;

/**
 * FileResourceInterface is fetching DAO properties
 * @author User
 *
 */
public interface FileResourceInterface {
	boolean addFileResource(FileResource fileresurce);
	boolean updateFileResource(FileResource fileresurce);
	ArrayList<FileResource> getAllFileResource(FileResource filereource);
	FileResource getFileResource(int fileid);
    ArrayList<FileResource> getFileResourcebyCategory(String Category);

}
