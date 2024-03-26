package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entities.Room;

public class RoomDAOImpl implements RoomDAO {

	private Session session;

	public RoomDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public void insert(Room crobj) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(crobj);
			tx.commit();
			System.out.println(crobj);
			System.out.println("Record inserted into Room table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Room> Display() {
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select crobj from Room crobj");
		@SuppressWarnings("unchecked")
		List<Room> list = (List<Room>) qobj.getResultList();
		tx.commit();
		return list;
	}

	public Room getbyroomid(int roomid) {
		System.out.println(roomid);
		try {
			return session.createQuery("FROM Room WHERE roomid =: roomid ", Room.class)

					.setParameter("roomid", roomid).uniqueResult();
		} catch (Exception e) {
			System.out.println("Error retrieving Price Details: " + e.getMessage());
			return null;
		}
	}
}
