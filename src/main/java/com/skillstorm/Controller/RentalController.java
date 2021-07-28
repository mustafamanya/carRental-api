package com.skillstorm.Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.RentalDAO;
import com.skillstorm.model.Rental;

@WebServlet (urlPatterns= "/rental")
public class RentalController extends HttpServlet {
	
	
	RentalDAO dao=new RentalDAO();

	
	// GET /trainee?id=
	
	// find by id
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(req.getParameter("id") != null) {
		String param= req.getParameter("id");
		int id= Integer.parseInt(param);
		Rental renter= dao.Findbooking(id);
		
		if( renter != null){
		String json= new ObjectMapper().writeValueAsString(renter); // converting java object->json
		System.out.println(json);
		resp.getWriter().print(json);
		}else{
			resp.getWriter().print("No renter information found");
		}
		
		}else {
			resp.getWriter().print("Please Enter an id");
			
		}
		
	}
	
	// add booking //must add getId like he did in create2
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody= req.getInputStream();
		Rental rent= new ObjectMapper().readValue(requestBody, Rental.class);
		resp.getWriter().print(new ObjectMapper().writeValueAsString(rent));
		resp.setContentType("application/json");
		System.out.println(rent);
		dao.AddBooking(rent);		
	}
	
	// update
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody= req.getInputStream();
		Rental rent= new ObjectMapper().readValue(requestBody, Rental.class);
		resp.getWriter().print(new ObjectMapper().writeValueAsString(rent));
		resp.setContentType("application/json");
		System.out.println(rent);
		dao.updateBooking(rent);
		
	}
	
	// delete booking 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("delete") !=null) {
		
		String param=req.getParameter("delete");
		int id= Integer.parseInt(param);
		dao.deleteBooking(new Rental(id));
		}else {
			resp.getWriter().print("Please Enter an id");
		}
		
	}

}
