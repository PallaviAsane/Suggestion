package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.PdfResourceDao;
import com.suggestion.daointerface.PdfResourceInterface;
import com.suggestion.model.PdfResource;




public class PdfResourceInterfaceService implements PdfResourceInterface{
	/**
	 * addPdfResource method calls PdfResourceDao's addPdfResource method to add PDF
	 * @return boolean result
	 */
	@Override
	public boolean addPdfResource(PdfResource pdfresource) {
		// TODO Auto-generated method stub
		boolean addppt=PdfResourceDao.addPdfResource(pdfresource);
		return addppt;
	}
	/**
	 * updatePdfResource method calls PdfResourceDao's updatePdfResource method to update PDF
	 * @return boolean result
	 */
	@Override
	public boolean updatePdfResource(PdfResource pdfresurce) {
		// TODO Auto-generated method stub
		boolean updatepdf=PdfResourceDao.updatePdfResource(pdfresurce);
		return updatepdf;
	}
	/**
	 * getAllPdfResource method calls PdfResourceDao's getAllPdfResource method to get list of PDFs
	 * @return ArrayList<PdfResource> as a result
	 */	
	@Override
	public ArrayList<PdfResource> getAllPptResource(PdfResource pptresource) {
		// TODO Auto-generated method stub
		ArrayList<PdfResource> pdflist=PdfResourceDao.getAllPdfResource(pptresource);
		return pdflist;
	}
	/**
	 * getPdfResource method calls PdfResourceDao's getPdfResource method to get single PDF
	 * @return PdfResource as a result
	 */
	@Override
	public PdfResource getPdfResource(int pdfid) {
		// TODO Auto-generated method stub
		PdfResource pdf=PdfResourceDao.getPdfResource(pdfid);
		return pdf;
	}

	@Override
	public PdfResource getsPdfResource(String category) {
		// TODO Auto-generated method stub
		PdfResource pdf=PdfResourceDao.getsPdfResource(category);
		return pdf;
	}

}
