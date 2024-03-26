package com.hotel.dao;

import com.hotel.entities.Admin;
import com.hotel.entities.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDAOImpl implements LoginDAO {

	private final Session session;

	public LoginDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public void getLoginById(int loginid) {
		try {
			Login lobj = session.find(Login.class, loginid);
			if (lobj == null)
				System.out.print("Record not found");
			else
				System.out.println(lobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(Login lobj) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(lobj);
			tx.commit();
			System.out.println(lobj);
			System.out.println("Record inserted into login table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Login lobj) {
		try {

			Transaction tx = session.beginTransaction();
			session.merge(lobj);
			tx.commit();
			System.out.println(lobj);
			System.out.println("Record updated into login table");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int loginid) {
		Transaction transaction = session.beginTransaction();
		try {
			Login lobj = session.get(Login.class, loginid);
			if (lobj != null) {
				session.delete(lobj);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public void getLoginByusernameAndpassword(String username, String password) {
		try {
			Login lobj = session.find(Login.class, username);
			if (lobj == null)
				System.out.print("Record not found");
			else
				System.out.println(lobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLoginByusernameAndpassword(Admin aobj) {

		try {
			Transaction tx = session.beginTransaction();
			Login lobj = new Login();

			lobj.setUsername(aobj.getUsername());
			lobj.setPassword(aobj.getPassword());
			System.out.println(lobj);
			// Save the Login object
			session.save(lobj);
			tx.commit();
			System.out.println("Record inserted into login table");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}