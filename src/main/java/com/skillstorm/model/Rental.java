package com.skillstorm.model;

import java.util.Objects;

//map to database 

public class Rental {
	
	
	private int id;
	private String renterName;
	private String location;
	private String start_date;
	private String end_date;
	private String amount;
	
	
	public Rental(int id, String renterName, String location, String start_date, String end_date, String amount) {
		super();
		this.id = id;
		this.renterName = renterName;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.amount = amount;
	}


	public Rental(String renterName, String location, String start_date, String end_date, String amount) {
		super();
		this.renterName = renterName;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.amount = amount;
	}


	public Rental(int id) {
		super();
		this.id = id;
	}


	public Rental() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRenterName() {
		return renterName;
	}


	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Rental [id=" + id + ", renterName=" + renterName + ", location=" + location + ", start_date="
				+ start_date + ", end_date=" + end_date + ", amount=" + amount + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, end_date, id, location, renterName, start_date);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rental other = (Rental) obj;
		return amount == other.amount && Objects.equals(end_date, other.end_date) && id == other.id
				&& Objects.equals(location, other.location) && Objects.equals(renterName, other.renterName)
				&& Objects.equals(start_date, other.start_date);
	} 
	
	


}
