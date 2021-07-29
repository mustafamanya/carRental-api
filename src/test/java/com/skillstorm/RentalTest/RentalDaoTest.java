package com.skillstorm.RentalTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.data.RentalDAO;
import com.skillstorm.model.Rental;


public class RentalDaoTest {
	
	
	private final static String username ="root"; //least privledged
	private final static String url ="jdbc:mysql://localhost:3306/july_java";
	private final static String password="root";
	
	Set<Rental> renter;
	DaoTest dao=new DaoTest();
	
	int id=0;


	
	


	@BeforeClass
	public static void setUpBeforClass() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver has been loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong with driver");
			e.printStackTrace();
		}
		
	
		
	}
	
	@Before 
	public  void setup(){
		renter=dao.FindAll();
		
		
	}
	
	
	@Test
	public void TestCreate() {
		System.out.println("Test1");

		
		int size=renter.size(); //size of database set before addbooking 
		System.out.println(size);

		dao.AddBooking(new Rental("Melon Headss","lax", "2015-07-11", "2016-07-11", "900$"));
		Set<Rental> renter2=dao.FindAll();
		int size2= renter2.size();
		System.out.println(size2);

		assertEquals(size+1,size2);
				
		
	}
	
	
	@Test
	public void TestRemove() {
		System.out.println("Test2");
		int size=renter.size(); //size of database set before addbooking 
		System.out.println(size);
		

		dao.deleteBooking(new Rental(205));
		Set<Rental> renter2=dao.FindAll();
		int size2= renter2.size();
		System.out.println(size2);
		assertEquals(size-1,size2);
				
		
	}
	
	
	
	
}
