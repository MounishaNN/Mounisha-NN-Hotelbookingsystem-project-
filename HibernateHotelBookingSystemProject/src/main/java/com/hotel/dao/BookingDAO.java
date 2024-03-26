package com.hotel.dao;

import java.util.List;

import com.hotel.entities.Booking;

public interface BookingDAO {

	void insert(Booking robj);// insert

	public void update(int bookingid, String checkinDate, String checkinTime, String checkoutDate, String checkoutTime);// update

	List<Booking> select();// select

	void search(int bookingid);// retrieve

}
