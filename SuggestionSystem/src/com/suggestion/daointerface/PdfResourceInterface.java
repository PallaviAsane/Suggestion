package com.suggestion.daointerface;

import java.util.ArrayList;

import com.suggestion.model.PdfResource;
public interface PdfResourceInterface {
	boolean addPdfResource(PdfResource pdfresource);
	boolean updatePdfResource(PdfResource pdfresurce);
	public ArrayList<PdfResource> getAllPptResource(PdfResource pptresource);
	PdfResource getPdfResource(int pdfid);
   PdfResource getsPdfResource(String category);
}
