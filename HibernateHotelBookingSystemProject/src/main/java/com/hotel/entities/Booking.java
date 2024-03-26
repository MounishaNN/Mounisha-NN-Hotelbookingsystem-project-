package com.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;

	private String checkinDate;
	private String checkinTime;
	private String checkoutDate;
	private String checkoutTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomid")
	private Room crobj;
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "customerid") private Customer cobj;
	 * 
	 * @OneToMany(mappedBy = "robj", cascade = CascadeType.ALL) private
	 * List<Payment> pobj = new ArrayList<>();
	 */

	public Booking(int bookingid, String checkinDate, String checkinTime, String checkoutDate, String checkoutTime) {
		super();
		this.bookingid = bookingid;
		this.checkinDate = checkinDate;
		this.checkinTime = checkinTime;
		this.checkoutDate = checkoutDate;
		this.checkoutTime = checkoutTime;
	}

	public Booking() {
		super();
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public Room getCrobj() {
		return crobj;
	}

	public void setCrobj(Room crobj) {
		this.crobj = crobj;
	}

	/*
	 * public Customer getCobj() { return cobj; }
	 * 
	 * public void setCobj(Customer cobj) { this.cobj = cobj; }
	 * 
	 * public List<Payment> getPobj() { return pobj; }
	 * 
	 * public void setPobj(List<Payment> pobj) { this.pobj = pobj; }
	 */
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", checkinDate=" + checkinDate + ", checkinTime=" + checkinTime
				+ ", checkoutDate=" + checkoutDate + ", checkoutTime=" + checkoutTime + ", crobj=" + crobj + "]";
	}

}
