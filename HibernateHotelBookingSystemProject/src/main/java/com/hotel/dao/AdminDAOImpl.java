package com.hotel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hotel.entities.Admin;

public class AdminDAOImpl implements AdminDAO {

	private Session session;

	public AdminDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public Admin getAdminById(int adminid) {
		return session.get(Admin.class, adminid);
	}

	public void addAdmin(Admin aobj) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(aobj);
			tx.commit();

			System.out.println(aobj);
			System.out.println("Record inserted into Admin table");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateAdmin(Admin aobj) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(aobj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteAdmin(int adminid) {
		Transaction tx = null;
		try {
			Admin admin = session.get(Admin.class, adminid);
			if (admin != null) {
				tx = session.beginTransaction();
				session.delete(admin);
				tx.commit();
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public Admin getLoginByusernameAndpassword(String username, String password) {
		try {
			return session.createQuery("FROM Admin WHERE username= :username AND password = :password", Admin.class)

					.setParameter("username", username).setParameter("password", password).uniqueResult();
		} catch (Exception e) {
			System.out.println("Error retrieving login details: " + e.getMessage());
			return null;
		}
	}

	public Admin getAdminByusernameAndpassword(String username, String password) {
		try {
			Query<Admin> query = session.createQuery("FROM Admin WHERE username = :username AND password = :password",
					Admin.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
