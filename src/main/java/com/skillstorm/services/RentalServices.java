package com.skillstorm.services;

import com.skillstorm.model.Rental;

import java.util.Set;

import com.skillstorm.data.RentalDAO;


public class RentalServices {
	
	static RentalDAO dao=new RentalDAO();
	
	public static Rental FindRentalById(int id) {
		
		if(id != 0) {
		
		return dao.Findbooking(id);
		}else {
			System.out.println("please enter id");
			return new Rental();
			
		}
	}
	
	public static Set<Rental> allRental(){
		return dao.FindAll();
	}

	public static void create(Rental rental) {
		
		 dao.AddBooking(rental);
		
	}
	
	public static void update(Rental rentar) {
		
		dao.updateBooking(rentar);
	}
	
	
	public static void delete(Rental rentar) {
		
		dao.deleteBooking(rentar);
	}
}


