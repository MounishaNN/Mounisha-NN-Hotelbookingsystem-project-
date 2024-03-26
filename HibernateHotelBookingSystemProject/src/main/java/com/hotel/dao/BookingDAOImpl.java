package com.hotel.dao;

import com.hotel.entities.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import javax.persistence.Query;

public class BookingDAOImpl implements BookingDAO {

	private Session session;

	public BookingDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public void insert(Booking robj) {
		System.out.println(robj);
		try {
			Transaction tx = session.beginTransaction();
			session.save(robj);
			tx.commit();
			System.out.println(robj);
			System.out.println("Record inserted into Booking table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int bookingid, String checkinDate, String checkinTime, String checkoutDate,
			String checkoutTime) {
		try {

			Booking robj = session.find(Booking.class, bookingid);
			if (robj == null)
				System.out.print("Record not found");
			else {
				robj.setCheckinDate(checkinDate);
				robj.setCheckinTime(checkinTime);
				robj.setCheckoutDate(checkoutDate);
				robj.setCheckoutTime(checkoutTime);

				Transaction tx = session.beginTransaction();
				session.merge(robj);
				tx.commit();
				System.out.println(robj);
				System.out.println("Record updated into Booking table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(int bookingid) {
		try {
			Booking robj = session.find(Booking.class, bookingid);
			if (robj == null)
				System.out.print("Record not found");
			else
				System.out.println(robj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Booking> select() {
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select robj from Booking robj");
		@SuppressWarnings("unchecked")
		List<Booking> list = (List<Booking>) qobj.getResultList();
		tx.commit();
		return list;
	}

}
