package com.skillstorm.RentalTest;

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
	RentalDAO dao=new RentalDAO();


	
	


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
		
		int size=renter.size();
		
		
		
		
	}
	
}
