package com.skillstorm.RentalTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.skillstorm.model.Rental;




public class DaoTest {
	
	
	private final static String username ="root"; //least privledged
	private final static String url ="jdbc:mysql://localhost:3306/july_java";
	private final static String password="root";
	
	
	
	// Perform CURD: Create, Retrieve, Update, DELETE
	
		static {
			
			//1) load driver (force the class to be loaded to memory)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Something went wrong with driver");
				e.printStackTrace();
			}
			
			
		}
		
		
		public void AddBooking(Rental rental) {
			// try with resources java 7+, any resource that implements Autoclosable interface
		// 2 Make connection object
			try(Connection conn=DriverManager.getConnection(url,username,password)){
				
				// 3 statement object
				String sql= "INSERT into car_rentaltest(renter_name,location,start_date,end_date,amount) values(?, ?, ?, ?, ?);";
				PreparedStatement stmt= conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, rental.getRenterName());
				stmt.setString(2, rental.getLocation());
				stmt.setString(3, rental.getStart_date());
				stmt.setString(4, rental.getEnd_date());
				stmt.setString(5, rental.getAmount());
				
				//4  execute update 
				stmt.executeUpdate();
				
				ResultSet keys=stmt.getGeneratedKeys();
				keys.next(); //only returning one row
				
				int id= keys.getInt(1);
				rental.setId(id);				
			} catch (SQLException e) {
				e.printStackTrace();
			};	
			
		}
		
		
		public void deleteBooking(Rental rental) {
			
			try(Connection conn=DriverManager.getConnection(url,username,password)){
				String sql= "DELETE FROM car_rentaltest WHERE id=?;";
				PreparedStatement stmt= conn.prepareStatement(sql);
				stmt.setInt(1, rental.getId());				
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			};	
						
			
		}
		
		
		
		public void updateBooking(Rental rental) {
			
			try(Connection conn=DriverManager.getConnection(url,username,password)){
				String sql= "UPDATE car_rentaltest SET renter_name=?,location=?, start_date=?,end_date=?, amount=? WHERE id= ?;";
				PreparedStatement stmt= conn.prepareStatement(sql);
				stmt.setString(1, rental.getRenterName());
				stmt.setString(2, rental.getLocation());
				stmt.setString(3, rental.getStart_date());
				stmt.setString(4, rental.getEnd_date());
				stmt.setString(5, rental.getAmount());
				stmt.setInt(6, rental.getId());
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			};	
			
			
		}
		
		
		
		
		public Rental Findbooking(int id) {
			
			try(Connection conn=DriverManager.getConnection(url,username,password)){
				String sql= "select id, renter_name, location, start_date, end_date, amount from car_rentaltest where id=?";
						
						
				PreparedStatement stmt= conn.prepareStatement(sql);
				// rows returned from query.. starts at row 0
				stmt.setInt(1, id);
				ResultSet rs= stmt.executeQuery();
				if(rs.next() !=false) {;
					
					//object relation mapping (Hibernate, sping, jpa, ibaits)
					Rental renter= new Rental(rs.getInt("id"), rs.getString("renter_name"), rs.getString("location"), rs.getString("start_date"),rs.getString("end_date"), rs.getString("amount"));	
					return renter;
				}else {
					System.out.println(" renter does not exist");
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
		
		
		public Set<Rental> FindAll(){
			Set<Rental> results= new HashSet<>();
			
			try(Connection conn=DriverManager.getConnection(url,username,password)){
				
				//write sql
				String sql= "select id, renter_name, location, start_date, end_date, amount from car_rentaltest;";
				//create prepared statement
				PreparedStatement stmt= conn.prepareStatement(sql);
				// rows returned from query.. starts at row 0
				//execute query 
				ResultSet rs= stmt.executeQuery();
				while(rs.next()) {
					int id=rs.getInt(1);
					String  renter_name= rs.getNString(2);
					String location= rs.getNString(3);
					Date dateObj1= rs.getDate(4);
					Date dateObj2= rs.getDate(5);	
					String start_date=dateObj1.toString();
					String end_date=dateObj2.toString();
					String amount=rs.getNString(6);
					Rental renter= new Rental(id,renter_name,location,start_date,end_date,amount);
					results.add(renter);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return results;
			
		}
		
		
		
	

}
