package com.skillstorm.data;

import java.util.Set;

import com.skillstorm.model.Rental;

public class RentalDAOMain {

	public static void main(String[] args) {
		
		RentalDAO dao=new RentalDAO();
		// need to not allow duplicate bookings
		
		//dao.AddBooking(new Rental("Obama","lax", "2015-07-11", "2016-07-11", "900$"));
		//dao.deleteBooking(new Rental(122));
		
		//Rental renter= dao.Findbooking(66);
		//System.out.println(renter);
		
		//dao.updateBooking(new Rental(66,"MusalManMan","SF","2013-7-21", "2016-1-20", "800$"));
		
			Set<Rental> setRental= dao.FindAll();
			System.out.println(setRental);
			Set<Rental> setRental2= dao.FindAll();
			System.out.println(setRental2);

			System.out.println(setRental.equals(setRental2));
		
		
		
	}

}
