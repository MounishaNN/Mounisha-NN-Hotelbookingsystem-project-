package com.hotel.dao;

import com.hotel.entities.Admin;

public interface LoginDAO {
	void getLoginById(int loginid);

	void getLoginByusernameAndpassword(String username, String password);

	void addLoginByusernameAndpassword(Admin aobj);
}
