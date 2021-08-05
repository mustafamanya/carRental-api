package com.skillstorm.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Renderer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.RentalDAO;
import com.skillstorm.model.Rental;
import com.skillstorm.services.RentalServices;

@WebServlet (urlPatterns= "/rental")
public class RentalController extends HttpServlet {
	
	
	
	RentalServices rentalservice= new RentalServices();
	RentalDAO dao=new RentalDAO();

	
	// GET /trainee?id=
	
	// find by id
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doDispatch(req,resp);
		
		
	}
	
	// add booking //must add getId like he did in create2
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req,resp);

				
	}
	
	// update
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req,resp);

		
		
	}
	
	// delete booking 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req,resp);

		
	}
	
	public void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		requestURI = requestURI.replace(this.getServletContext().getContextPath(), "");
		String method= req.getMethod();
		System.out.println(requestURI);
		
		ObjectMapper mapper= new ObjectMapper();
		
		
		switch(method) {
		
		
		case "GET":
			if(req.getParameter("id")!=null) {
			String param= req.getParameter("id");
			int id= Integer.parseInt(param);
			Rental renter= rentalservice.FindRentalById(id);
			if(renter!=null) {
			String json= new ObjectMapper().writeValueAsString(renter);
			resp.getWriter().print(json);
			resp.setContentType("application/json");
			}else {
				resp.getWriter().print("no renter with that id found");
				
			}
			
			}else {
				
				Set<Rental>renter= rentalservice.allRental();
				String json= new ObjectMapper().writeValueAsString(renter);
				resp.getWriter().print(json);
				
				
				
			}
			
		case "POST":
			InputStream requestBody= req.getInputStream();
			Rental rent= new ObjectMapper().readValue(requestBody, Rental.class);
			rentalservice.create(rent);
			resp.getWriter().print(new ObjectMapper().writeValueAsString(rent));
			resp.setContentType("application/json");
			System.out.println(rent);
			
			
		
		
		case "PUT":
			
			InputStream requestBody2= req.getInputStream();
			Rental rent2= new ObjectMapper().readValue(requestBody2, Rental.class);
			resp.getWriter().print(new ObjectMapper().writeValueAsString(rent2));
			resp.setContentType("application/json");
			System.out.println(rent2);
			rentalservice.create(rent2);

		
		
		
		
		
		case "DELETE":
			
			if(req.getParameter("id") !=null) {
				
				String param=req.getParameter("id");
				int id= Integer.parseInt(param);
				Rental rental=new Rental(id);
				System.out.println(rental);
				rentalservice.delete(rental);
				resp.getWriter().print(new ObjectMapper().writeValueAsString(rental));

				}else {
					resp.getWriter().print("Please Enter an id");
				}
			
		
		
		
	}
	
	

	
	
	
	

}
}
