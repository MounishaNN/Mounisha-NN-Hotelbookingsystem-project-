package com.hotel;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.Session;

import com.Room.Utils.RoomUtils;
import com.hotel.dao.AdminDAO;
import com.hotel.dao.AdminDAOImpl;
import com.hotel.dao.BookingDAO;
import com.hotel.dao.BookingDAOImpl;
import com.hotel.dao.CustomerDAOImpl;
import com.hotel.dao.LoginDAO;
import com.hotel.dao.LoginDAOImpl;
import com.hotel.dao.PaymentDAO;
import com.hotel.dao.PaymentDAOImpl;
import com.hotel.dao.RoomDAO;
import com.hotel.dao.RoomDAOImpl;
import com.hotel.entities.Admin;
import com.hotel.entities.Booking;
import com.hotel.entities.Customer;
import com.hotel.entities.Login;
import com.hotel.entities.Payment;
import com.hotel.entities.Registration;
import com.hotel.entities.Room;

public class Menu {

	// org.hibernate.SessionFactory factory = new
	// org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	// org.hibernate.Session session = factory.openSession();

	Scanner scanner = new Scanner(System.in);
	LoginDAO logindao;
	AdminDAO admindao;
	CustomerDAOImpl ciobj;
	Roomcrud crud;
	RoomDAO roomdao;
	BookingDAO bookingDao;
	PaymentDAO paymentDao;

	private static Session session;

	Menu(Session session) {
		this.session = session;
		logindao = new LoginDAOImpl(session);
		admindao = new AdminDAOImpl(session);
		ciobj = new CustomerDAOImpl(session);
		crud = new Roomcrud();
		roomdao = new RoomDAOImpl(session);
		bookingDao = new BookingDAOImpl(session);
		paymentDao = new PaymentDAOImpl(session);
	}

	Admin aobj = new Admin();

	public void createAdminAccount() {
		try {
			System.out.println("***** Admin Registration *****");
			System.out.println("Enter Admin details");
			System.out.print("Enter admin name: ");
			String name = scanner.next();
			System.out.print("Enter username: ");
			String username = scanner.next();
			System.out.print("Enter your password: ");
			String password = scanner.next();
			System.out.println("Enter your Contact: ");
			String contact = scanner.next();
			aobj.setName(name);
			aobj.setPassword(password);
			aobj.setUsername(username);
			aobj.setContact(contact);

			Registration reobj = new Registration();
			aobj.setReobj(reobj);
			reobj.setAobj(aobj);
			admindao.addAdmin(aobj);
			System.out.println(aobj);
			System.out.println(reobj);

			System.out.println("Admin Registration successful!");
		} catch (Exception e) {
			System.out.println("Admin Registration failed. Please try again.");
			e.printStackTrace();
		}
	}

	public void login() {
		System.out.println("*****  LOGIN *****");
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter Password:");
		String password = scanner.next();

		// Use AdminDAO to fetch admin details by username
		Admin aobj = admindao.getLoginByusernameAndpassword(username, password);
		System.out.println(aobj);

		if (aobj == null) {
			System.out.println("Login failed. Invalid username or password.");
		} else {
			logindao.addLoginByusernameAndpassword(aobj);
			System.out.println("Admin login successful!");
			Login lobj = new Login();
			lobj.setAobj(aobj);
			Adminmenu();
		}
	}

//booking, customer details and payment
	public void bookingroom() {
		try {
			Customer cobj = customerDetails();
			Booking robj = BookingDetails();
			Payment pobj = paymentdetails(robj);
			System.out.print(pobj.toString());
			ciobj.insert(cobj);
			bookingDao.insert(robj);
			paymentDao.insert(pobj);
			pobj.setRobj(robj);
		} catch (Exception e) {
			System.out.println("Back to Admin Menu");
			e.printStackTrace();
		}
	}

	public Customer customerDetails() {
		System.out.println("************** Create New Customer Account ************");

		System.out.println("Enter customer details");
		scanner.nextLine();
		System.out.println("Enter customer name: ");
		String name = scanner.nextLine();

		System.out.println("Enter customer address: ");
		String address = scanner.nextLine();

		System.out.println("Enter customer Pancardno: ");
		String panCardNo = scanner.nextLine();

		System.out.println("Enter customer Contact: ");
		String contact = scanner.nextLine();

		System.out.println("Enter licenseno: ");
		String licenseno = scanner.nextLine();

		Customer cobj = new Customer();
		cobj.setName(name);
		cobj.setAddress(address);
		cobj.setPanCardNo(panCardNo);
		cobj.setContact(contact);
		cobj.setLicenseNo(licenseno);

		cobj.setAobj(aobj);

		return cobj;
	}

	public Booking BookingDetails() {
		System.out.println(" Enter the Booking, Room  and customer Details ");
		System.out.print(" Enter Room id :");
		int roomid = scanner.nextInt();
		Room roomObj = roomdao.getbyroomid(roomid);
		System.out.print(" Enter Checkin Date(yyyy-mm-dd):  ");
		String checkinDate = scanner.next();

		System.out.print(" Enter checkinTime (hh:mm:ss)  :");
		String checkinTime = scanner.next();
		System.out.print(" Enter checkoutDate (yyyy-mm-dd): ");

		String checkoutDate = scanner.next();

		System.out.print(" checkoutTime  (hh:mm:ss):");
		String checkoutTime = scanner.next();

		Booking robj = new Booking();
		robj.setCheckinDate(checkinDate);
		robj.setCheckinTime(checkinTime);
		robj.setCheckoutDate(checkoutDate);
		robj.setCheckoutTime(checkoutTime);
		robj.setCrobj(roomObj);
		return robj;

	}

	public Payment paymentdetails(Booking robj) {
		Payment pobj = new Payment();
		LocalDateTime CheckinTime = RoomUtils.convertStringToDate(robj.getCheckinDate(), robj.getCheckinTime());
		LocalDateTime CheckoutTime = RoomUtils.convertStringToDate(robj.getCheckoutDate(), robj.getCheckoutTime());
		int BookingHours = RoomUtils.getBookingHours(CheckoutTime, CheckinTime);
		pobj.setDate(RoomUtils.getCurrentDate());
		int totalPayment = BookingHours * robj.getCrobj().getPrice();
		pobj.setAmount(totalPayment);
		pobj.setRobj(robj);
		return pobj;
	}

	public void Adminmenu() {
		System.out.println(" Welcome to Admin Side");
		System.out.println("1) View Rooms");
		System.out.println("2)  Add Rooms");
		System.out.println("3) Boking Rooms");
		System.out.println("4) Exit to main menu ");
		System.out.println(" Enter  the choice ");
		int ch = scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println(" Display  Room details ");
			crud.Display();
			Adminmenu();
			break;
		case 2:
			System.out.println(" Add  Room details ");
			crud.insert();
			Adminmenu();
		case 3:
			System.out.println(" Booking Room");

			bookingroom();
			Adminmenu();
			break;

		case 4:
			System.out.println(" Return to main page ");
			System.exit(0);
			break;
		default:
			break;
		}
	}

}
