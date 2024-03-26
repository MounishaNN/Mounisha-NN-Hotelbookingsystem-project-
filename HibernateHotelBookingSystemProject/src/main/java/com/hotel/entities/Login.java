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
@Table(name = "LOGIN")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginid;

	private String username;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminid")
	private Admin aobj;

	public Login(int loginid, String username, String password) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
	}

	// Adding getters and setters

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
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

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}

	@Override
	public String toString() {
		return "Login [loginid=" + loginid + ", username=" + username + ", password=" + password + ",aobj=" + aobj
				+ "]";
	}

	public Admin getAdmin() {

		return aobj;
	}
}
