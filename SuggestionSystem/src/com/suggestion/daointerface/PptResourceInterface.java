package com.suggestion.daointerface;

import java.util.ArrayList;

import com.suggestion.model.PptResource;

public interface PptResourceInterface {
	boolean addPptResource(PptResource pptresurce);
	boolean updatePptResource(PptResource pptresurce);
	ArrayList<PptResource> getAllPptResource(PptResource pptreource);
	PptResource getPptResource(int pptid);
	ArrayList<PptResource> getPptResourcebyCategory(String Category);
}
