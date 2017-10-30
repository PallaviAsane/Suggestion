package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.PptResourceDao;
import com.suggestion.daointerface.PptResourceInterface;
import com.suggestion.model.PptResource;

/**
 * 
 * @author User
 *
 */
public class PptResourceInterfaceService implements PptResourceInterface{

	/**
	 * addPptResource method calls PptResourceDao's addPptResource method to add PPT
	 * @return boolean result
	 */
	@Override
	public boolean addPptResource(PptResource pptresurce) {
		// TODO Auto-generated method stub
		boolean addppt=PptResourceDao.addPptResource(pptresurce);
		return addppt;
	}//addPptResource

	/**
	 * updatePptResource method calls PptResourceDao's updatePptResource method to update PPT
	 * @return boolean result
	 */
	@Override
	public boolean updatePptResource(PptResource pptresurce) {
		// TODO Auto-generated method stub
		boolean updateppt=PptResourceDao.updatePptResource(pptresurce);
		return updateppt;
	}//updatePptResource

	/**
	 * getAllPptResource method calls PptResourceDao's getAllPptResource method to get list of PPTs
	 * @return ArrayList<PptResource> as a result
	 */	
	@Override
	public ArrayList<PptResource> getAllPptResource(PptResource pptreource) {
		// TODO Auto-generated method stub
		ArrayList<PptResource> pptlist=PptResourceDao.getAllPptResource(pptreource);
		return pptlist;
	}//getAllPptResource
	
	/**
	 * getPptResource method calls PptResourceDao's getPptResource method to get single ppt
	 * @return PptResource as a result
	 */
	@Override
	public PptResource getPptResource(int pptid) {
		// TODO Auto-generated method stub
		PptResource ppt=PptResourceDao.getPptResource(pptid);
		return ppt;
	}//getPptResource

	@Override
	public ArrayList<PptResource> getPptResourcebyCategory(String Category) {
		// TODO Auto-generated method stub
		ArrayList<PptResource> pptlist=PptResourceDao.getPptResourcebyCategory(Category);
		return pptlist;
	}

}
