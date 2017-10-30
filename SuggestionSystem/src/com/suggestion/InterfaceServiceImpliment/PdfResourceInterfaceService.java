package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.PdfResourceDao;
import com.suggestion.daointerface.PdfResourceInterface;
import com.suggestion.model.PdfResource;




public class PdfResourceInterfaceService implements PdfResourceInterface{

	@Override
	public boolean addPdfResource(PdfResource pdfresource) {
		// TODO Auto-generated method stub
		boolean addppt=PdfResourceDao.addPdfResource(pdfresource);
		return addppt;
	}

	@Override
	public boolean updatePdfResource(PdfResource pdfresurce) {
		// TODO Auto-generated method stub
		boolean updatepdf=PdfResourceDao.updatePdfResource(pdfresurce);
		return updatepdf;
	}

	@Override
	public ArrayList<PdfResource> getAllPptResource(PdfResource pptresource) {
		// TODO Auto-generated method stub
		ArrayList<PdfResource> pdflist=PdfResourceDao.getAllPdfResource(pptresource);
		return pdflist;
	}

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
