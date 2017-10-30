package com.suggestion.InterfaceServiceImpliment;

import java.util.ArrayList;
import java.util.List;




import com.suggestion.dao.AdminDao;
import com.suggestion.daointerface.AdminInterface;
import com.suggestion.model.Admin;

public class AdminInterfaceServices implements AdminInterface{

	@Override
	public int addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin getAdmin(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		List<Admin> gets=AdminDao.getAdmin();
		return gets;
	}

	@Override
	public int deleteAdmin(int AdminId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdmin(int adminId, String adminname, String adminpassword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
