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
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;

	private String name;
	private String address;
	private String panCardNo;
	private String contact;
	private String licenseno;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminid")
	private Admin aobj;

	/*
	 
	  @OneToMany(cascade = CascadeType.ALL,mappedBy="cobj") private List<Payment>
	  pobj=new ArrayList<Payment>();
	 */
	public Customer() {
		super();

	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLicenseNo() {
		return licenseno;
	}

	public void setLicenseNo(String licenseno) {
		this.licenseno = licenseno;
	}

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", name=" + name + ", address=" + address + ", panCardNo="
				+ panCardNo + ", contact=" + contact + ", licenseno=" + licenseno + ",aobj=" + aobj + "]";
	}

}
