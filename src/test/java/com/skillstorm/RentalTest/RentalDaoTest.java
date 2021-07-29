package com.skillstorm.RentalTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	

	
	DaoTest dao=new DaoTest();
	

	
	@Before
	public void beforeTest() {
		
		try {
			String ddl= "create table car_rentaltest (\r\n"
					+ "	id INT NOT NULL AUTO_INCREMENT ,\r\n"
					+ "	renter_name VARCHAR(50),\r\n"
					+ "	location VARCHAR(50),\r\n"
					+ "	start_date DATE,\r\n"
					+ "	end_date DATE,\r\n"
					+ "	amount VARCHAR(50),\r\n"
					+ "	PRIMARY KEY(id)\r\n"
					+ ");\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "";
				Connection conn= DriverManager.getConnection(url,username,password);
				Statement stmt= conn.createStatement();
				stmt.executeUpdate(ddl);
				System.out.println("Test table created");
					
			
		}catch(Exception e) {
			System.out.println("Table failed");
		}
		
		
		
	}
	
	
	@Test
	public void TestCreate() {
	
	try {
		String sql= "select count(*) from car_rentaltest"; 
		Connection conn= DriverManager.getConnection(url,username,password);
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);
		rs.next();
		int rowsBefore = rs.getInt(1);
		
		dao.AddBooking(new Rental("Melon Headss","lax", "2015-07-11", "2016-07-11", "900$"));
		
		ResultSet rs2= stmt.executeQuery(sql);
		rs2.next();
		int rowsAfter = rs2.getInt(1);
		System.out.println(rowsAfter + " "+ rowsBefore);
		
		assertEquals(rowsAfter, ++rowsBefore);
		
	}catch(Exception e) {
		System.out.print("failed");
	}
	
	}
	
	@Test
	public void FindId() {
		
		try {
			System.out.println("Remove test");
			Connection conn= DriverManager.getConnection(url,username,password);
			Statement stmt= conn.createStatement();
			
			// first adding a booking 
			dao.AddBooking(new Rental("Melon Headss","lax", "2015-07-11", "2016-07-11", "900$"));
			
			Rental result=dao.Findbooking(1);
			Rental expected= new Rental(1,"Melon Headss","lax", "2015-07-11", "2016-07-11", "900$");
			
			if(expected.equals(result)) {
				System.out.println(" Find works");
				
			}else {
				System.out.println("Find failed ");
				fail();
			}
			
		}catch(Exception e) {
			System.out.print("failed");
		
		}
	}
	
	// will test for rental 100 
	@Test
	public void Remove() {
		
		try {
			System.out.println("Remove test");
			Connection conn= DriverManager.getConnection(url,username,password);
			Statement stmt= conn.createStatement();
			
			// first adding a booking 
			dao.AddBooking(new Rental("Melon Headss","lax", "2015-07-11", "2016-07-11", "900$"));
			
			// before should not be 1 
			String sql= "select count(*) from car_rentaltest"; 
			ResultSet rs= stmt.executeQuery(sql);


			rs.next();
			int rowsBefore = rs.getInt(1);
			
			dao.deleteBooking(new Rental(1));
			
			ResultSet rs2= stmt.executeQuery(sql);
			rs2.next();
			int rowsAfter = rs2.getInt(1);
			System.out.println(rowsAfter + " "+ rowsBefore);
			
			// since Rowbefore is 1 and if remove works Rowafter should be 0. Therefore --RowBefore to see if they are equal.
			
			assertEquals(rowsAfter, --rowsBefore);
			
		}catch(Exception e) {
			System.out.print("failed");
		}

		
	}
	
	@After 
	public void afterTest() {
		try {
			Connection conn= DriverManager.getConnection(url,username,password);
			Statement stmt= conn.createStatement();
			stmt.executeUpdate("drop table car_rentaltest ");
			System.out.println("Table dropped ");
			conn.close();
		}catch(Exception e) {
			fail();
		}
		
	}
	
	
	
	
}
