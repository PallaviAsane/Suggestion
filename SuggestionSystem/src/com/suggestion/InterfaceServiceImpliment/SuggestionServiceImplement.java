package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;

import com.suggestion.dao.SuggestionDao;
import com.suggestion.daointerface.SuggestionInterface;
import com.suggestion.model.Suggestion;



public class SuggestionServiceImplement implements SuggestionInterface {

	@Override
	public boolean addCookies(Suggestion cookies) {
		// TODO Auto-generated method stub
		boolean addcookie=SuggestionDao.addCookies(cookies);
		return addcookie;
	}

	@Override
	public boolean updateCookies(Suggestion cookies) {
		// TODO Auto-generated method stub
		boolean updatecookie=SuggestionDao.updateCookies(cookies);
		return updatecookie;
	}

	@Override
	public Suggestion getCookies(int fileid) {
		// TODO Auto-generated method stub
		Suggestion getcookie=SuggestionDao.getCookies(fileid);
		return getcookie;
	}

	@Override
	public ArrayList<Suggestion> getsCookies(Suggestion cookies) {
		// TODO Auto-generated method stub
		ArrayList<Suggestion> getcookies=SuggestionDao.getsCookies(cookies);
		return getcookies;
	}

	


}
