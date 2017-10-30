package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.FileResourceDao;
import com.suggestion.daointerface.FileResourceInterface;
import com.suggestion.model.FileResource;
/**
 * FileResourceInterfaceService implements FileResourceInterface
 * @author User
 *
 */
public class FileResourceInterfaceService implements FileResourceInterface{

	/**
	 * addFileResource method calls FileResourceDao's addFileResource method to add file
	 * @return boolean result
	 */
	@Override
	public boolean addFileResource(FileResource fileresurce) {
		// TODO Auto-generated method stub
		boolean addfile=FileResourceDao.addFileResource(fileresurce);
		return addfile;
	}//end method addFileResource

	/**
	 * updateFileResource method calls FileResourceDao's updateFileResource method to update file
	 * @return boolean result
	 */
	@Override
	public boolean updateFileResource(FileResource fileresurce) {
		// TODO Auto-generated method stub
		boolean updatefile=FileResourceDao.updateFileResource(fileresurce);
		return updatefile;
	}// end method updateFileResource

	/**
	 * getAllFileResource method calls FileResourceDao's getAllFileResource method to get list of file
	 * @return ArrayList<FileResource> as a result
	 */	
	@Override
	public ArrayList<FileResource> getAllFileResource(FileResource filereource) {
		// TODO Auto-generated method stub
		ArrayList<FileResource> getfilelist=FileResourceDao.getAllFileResource(filereource);
		return getfilelist;
	}//ent method getAllFileResource

	/**
	 * getFileResource method calls FileResourceDao's getFileResource method to get single file
	 * @return FileResource as a result
	 */
	@Override
	public FileResource getFileResource(int fileid) {
		// TODO Auto-generated method stub
		FileResource file=FileResourceDao.getFileResource(fileid);
		return file;
	}//end method getFileResource

	/**
	 * getFileResourcebyCategory method calls FileResourceDao's getFileResourcebyCategory method to get single file by category
	 * @return FileResource as a result
	 */
	@Override
	public ArrayList<FileResource> getFileResourcebyCategory(String Category) {
		// TODO Auto-generated method stub
		ArrayList<FileResource> filelist=FileResourceDao.getFileResourcebyCategory(Category);
		return filelist;
	}

}
