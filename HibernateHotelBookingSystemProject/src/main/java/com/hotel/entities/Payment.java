package com.hotel.entities;

/*
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	private String payment_date;
	private double payment_amount;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "payment")
	@JoinColumn(name = "booking_id")
	private Booking booking;

	
	public Payment(int payment_id, String payment_date, double payment_amount) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.payment_amount = payment_amount;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String date) {
		this.payment_date = date;
	}

	public double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_date=" + payment_date + ", payment_amount="
				+ payment_amount + ", booking=" + booking + "]";
	}

	public void setBobj(Booking booking) {
		
	}

}
*/
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;

	private int Amount;
	private String date;
	private int additionalcharges;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingid")
	private Booking robj;

	public Payment() {
		super();
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAdditionalcharges() {
		return additionalcharges;
	}

	public void setAdditionalcharges(int additionalcharges) {
		this.additionalcharges = additionalcharges;
	}

	public Booking getRobj() {
		return robj;
	}

	public void setRobj(Booking robj) {
		this.robj = robj;
	}

	/*
	 * public Customer getCobj() { return cobj; }
	 * 
	 * public void setCobj(Customer cobj) { this.cobj = cobj; }
	 * 
	 * public Admin getAobj() { return aobj; }
	 * 
	 * public void setAobj(Admin aobj) { this.aobj = aobj; }
	 */
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", Amount=" + Amount + ", date=" + date + ", additionalcharges="
				+ additionalcharges + ", robj=" + robj + "]";
	}
}