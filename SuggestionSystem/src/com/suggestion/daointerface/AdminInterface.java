package com.suggestion.daointerface;

import java.util.List;

import com.suggestion.model.Admin;




public interface AdminInterface {
	public int addAdmin(Admin admin);
	public Admin getAdmin(int userid);
	public List<Admin> getAdmin();
	public int deleteAdmin(int AdminId);
	public int updateAdmin(int adminId, String adminname,String adminpassword);

}
