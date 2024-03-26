package com.hotel;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		try {

			Menu menu = new Menu(session);
			int choice;

			do {
				System.out.println();
				System.out.println("--------WELCOME Room Booking SYSTEM--------");
				System.out.println("1) Admin Registration");
				System.out.println("2) Log In");
				System.out.println("3) Exit");
				System.out.println("Enter Your Choice:");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					menu.createAdminAccount();
					break;
				case 2:
					menu.login();
					break;
				case 3:
					System.out.println(" Thank You Visit Again");
					System.exit(0);
					break;
				}
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		session.clear();
	}
}
