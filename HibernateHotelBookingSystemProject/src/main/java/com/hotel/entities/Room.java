package com.hotel.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomid;

	private int roomno;
	private String roomtype;
	private String service;
	private int noofpeople;
	private int price;
	private String Status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminid")
	private Admin aobj;

	/*
	 
	  @ManyToMany( cascade = CascadeType.ALL,mappedBy = "crobj") private
	  List<Customer> cobj = new ArrayList<Customer>();
	 */
	public Room() {
		super();
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getNoofpeople() {
		return noofpeople;
	}

	public void setNoofpeople(int noofpeople) {
		this.noofpeople = noofpeople;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}

	/*
	 * 
	 * 
	 * public List<Customer> getCobj() { return cobj; }
	 * 
	 * public void setCobj(List<Customer> cobj) { this.cobj = cobj; }
	 */
	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomno=" + roomno + ", Roomtype=" + roomtype + ", service=" + service
				+ ", Noofpeople=" + noofpeople + ", price=" + price + ", Status=" + Status + ", aobj=" + aobj + "]";
	}
}
