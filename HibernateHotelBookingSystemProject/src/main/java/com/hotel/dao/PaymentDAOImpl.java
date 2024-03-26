package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entities.Payment;

public class PaymentDAOImpl implements PaymentDAO {

	private Session session;

	public PaymentDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public void insert(Payment pobj) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(pobj);
			tx.commit();
			System.out.println(pobj);
			System.out.println("Record inserted into Payment table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(int paymentid) {
		try {
			Payment pobj = session.find(Payment.class, paymentid);
			if (pobj == null)
				System.out.print("Record not found");
			else
				System.out.println(pobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Payment> select() {
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select pobj from Payment pobj ");
		@SuppressWarnings("unchecked")
		List<Payment> list = (List<Payment>) qobj.getResultList();
		tx.commit();
		return list;
	}

	public void getPaymentById(int paymentid) {
		try {
			Payment pobj = session.find(Payment.class, paymentid);
			if (pobj == null)
				System.out.print("Record not found");
			else
				System.out.println(pobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
