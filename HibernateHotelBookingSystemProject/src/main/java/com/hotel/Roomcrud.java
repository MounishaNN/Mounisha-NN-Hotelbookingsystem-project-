package com.hotel;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hotel.dao.RoomDAO;
import com.hotel.dao.RoomDAOImpl;
import com.hotel.entities.Admin;
import com.hotel.entities.Room;

public class Roomcrud {

	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory sf = meta.getSessionFactoryBuilder().build(); // Create a SessionFactory object
	Session session = sf.openSession();
	Scanner sc = new Scanner(System.in);
	Admin aobj = new Admin();
	RoomDAO roomdao = new RoomDAOImpl(session);

	public void insert() {

		System.out.println("==Enter Room details==");
		System.out.print("Enter Room Number: ");
		int roomno = sc.nextInt();

		System.out.println(" Enter Room Type: ");
		String roomType = sc.next();
		sc.nextLine();

		System.out.println("Enter Room Services: ");
		String services = sc.nextLine();

		System.out.print("Enter No of people stay ");
		int noofpeople = sc.nextInt();

		System.out.print("Enter price ");
		int price = sc.nextInt();

		System.out.print("Is Room available? (yes/no): ");
		String status = sc.next();

		Room crobj = new Room();

		crobj.setRoomno(roomno);
		crobj.setRoomtype(roomType);
		crobj.setService(services);
		crobj.setNoofpeople(noofpeople);
		crobj.setPrice(price);
		crobj.setStatus(status);

		roomdao.insert(crobj);
		crobj.setAobj(aobj);

	}

	public void Display() {
		List<Room> allRooms = roomdao.Display();

		if (allRooms != null && !allRooms.isEmpty()) {
			System.out.println("All Room Details:");

			for (Room crobj : allRooms) {
				System.out.println("-----------------------------");
				System.out.println("Room ID: " + crobj.getRoomid());
				System.out.println("Room no: " + crobj.getRoomno());
				System.out.println("Room type:" + crobj.getRoomtype());
				System.out.println("Room Service: " + crobj.getService());
				System.out.println(" No of peoplestay: " + crobj.getNoofpeople());
				System.out.println("Price:" + crobj.getPrice());
				System.out.println("Room  status : " + crobj.getStatus());
				System.out.println("-----------------------------");
			}
		} else {
			System.out.println("No Rooms found.");
		}
	}

	public void Search() {
		System.out.println("Enter the Room ID to retrieve details:");

		String roomid = sc.nextLine();

		Room crobj = session.find(Room.class, roomid);

		if (crobj != null) {
			System.out.println("Room Details for ID " + roomid + ":");
			System.out.println("Room ID: " + crobj.getRoomid());
			System.out.println("Room number" + crobj.getRoomno());
			System.out.println("Room Type: " + crobj.getRoomtype());
			System.out.println("Room Service: " + crobj.getService());
			System.out.println("no of people stay : " + crobj.getNoofpeople());
			System.out.println("Room  status : " + crobj.getStatus());
			System.out.println("---------");

		} else {
			System.out.println("Room with ID " + roomid + " not found.");
		}
	}
}
