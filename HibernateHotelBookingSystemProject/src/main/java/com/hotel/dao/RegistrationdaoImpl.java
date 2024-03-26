package com.hotel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entities.Registration;

public class RegistrationdaoImpl implements Registrationdao {

	private Session session;

	public RegistrationdaoImpl(Session session) {
		super();
		this.session = session;
	}

	public void insert(Registration reobj) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(reobj);
			tx.commit();

			System.out.println(reobj);
			System.out.println("Record inserted into Registration table");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
