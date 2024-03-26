package com.hotel.dao;

import java.util.List;

import com.hotel.entities.Payment;

public interface PaymentDAO {

	void insert(Payment pobj);// insert

	List<Payment> select();// select

	void search(int paymentid);// retrieve

	public void getPaymentById(int paymentid);
}