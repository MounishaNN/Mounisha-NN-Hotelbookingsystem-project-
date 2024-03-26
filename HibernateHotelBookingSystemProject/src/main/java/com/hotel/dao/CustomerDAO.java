package com.hotel.dao;

import java.util.List;

import com.hotel.entities.Customer;

public interface CustomerDAO {
	void insert(Customer cobj);// insert

	void update(int customerid, String name, String address, String pancardno, String contact, String liscenseno);// update

	List<Customer> select();// select

	void search(int customerid);// retrieve
}
