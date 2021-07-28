package com.skillstorm.RentalTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class RentalDaoTest {
	
	
	private final static String username ="root"; //least privledged
	private final static String url ="jdbc:mysql://localhost:3306/july_java";
	private final static String password="root";
	
	


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
		System.out.println("Set up connection ");
		
		
	}
	
	
	@Test
	public void test() {
		
		System.out.println("hello");
	}
	
}
