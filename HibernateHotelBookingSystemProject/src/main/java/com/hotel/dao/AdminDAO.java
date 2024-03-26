package com.hotel.dao;

import com.hotel.entities.Admin;

public interface AdminDAO {

	Admin getAdminById(int adminid);

	Admin getAdminByusernameAndpassword(String username, String password);

	void addAdmin(Admin aobj);

	void updateAdmin(Admin aobj);

	void deleteAdmin(int adminid);

	Admin getLoginByusernameAndpassword(String username, String password);

}