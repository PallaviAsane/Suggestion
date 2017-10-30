package com.suggestion.InterfaceServiceImpliment;

import com.suggestion.dao.CookiesDao;
import com.suggestion.daointerface.CookiesInterface;
import com.suggestion.model.Cookies;



public class CookiesServiceImplement implements CookiesInterface {

	@Override
	public boolean addCookies(Cookies cookies) {
		// TODO Auto-generated method stub
		boolean addcookie=CookiesDao.addCookies(cookies);
		return addcookie;
	}

	@Override
	public boolean updateCookies(Cookies cookies) {
		// TODO Auto-generated method stub
		boolean updatecookie=CookiesDao.updateCookies(cookies);
		return updatecookie;
	}

	


}
