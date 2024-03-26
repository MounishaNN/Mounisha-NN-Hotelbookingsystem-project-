package com.hotel.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;

	private String name;
	private String username;
	private String password;
	private String contact;

	/*
	 * @OneToMany(cascade = CascadeType.ALL,mappedBy="aobj") private List<Payment>
	 * pobj=new ArrayList<Payment>();
	 */
	@OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn (name = "regid")
	private Registration reobj;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
//public List<Car> getCrobj() {
//	return crobj;
//}
//
//public void setCrobj(List<Car> crobj) {
//	this.crobj = crobj;
//}

//public List<Payment> getPobj() {
//	return pobj;
//}
//
//public void setPobj(List<Payment> pobj) {
//	this.pobj = pobj;
//}

	public Registration getReobj() {
		return reobj;
	}

	public void setReobj(Registration reobj) {
		this.reobj = reobj;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", contact=" + contact + ",reobj=" + reobj + "]";
	}

}
