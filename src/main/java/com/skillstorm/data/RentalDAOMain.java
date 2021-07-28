package com.skillstorm.data;

import com.skillstorm.model.Rental;

public class RentalDAOMain {

	public static void main(String[] args) {
		
		RentalDAO dao=new RentalDAO();
		// need to not allow duplicate bookings
		
		//dao.AddBooking(new Rental("Obama","lax", "2015-07-11", "2016-07-11", "900$"));
		//dao.deleteBooking(new Rental(112));
		
//		Rental renter= dao.Findbooking(66);
//		System.out.println(renter.getRenterName());
		
		dao.updateBooking(new Rental(4,"MusalManMan","SF","2013-7-21", "2016-1-20", "800$"));
		
	}

}
