package com.skillstorm.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/process")
public class RentalServlet extends HttpServlet{
	
	
	//Get request to /api/process
	// route mapping
	//HTTP is a plain-text protocol
	
	//do get is getting information from server to web application
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getMethod");
		PrintWriter out= resp.getWriter(); // write data to the http response
		out.println("{\"data\" : {}}");
	}
	
	//HttpServlet has methods to handle each type of http request method: GET, POST, PUT, DELETE
	
	// use post when you want to send data to the server, create/update should be used for a list 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post Method");
		
		String line=null;
		BufferedReader reader= req.getReader();
		
		while((line= reader.readLine())!=null) {
			
			System.out.println(line);
		}
		//HTTP request body can store data 
		
		
	}
	
	// use put when you want to create/update should be used for a one element 

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Put Method");
	}
	
	
	// /process?param=value
	// http://localhost:8080/carRental-api/process?id=101
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Delete Method");
		System.out.println(req.getParameter("id"));
	
	}
}
//
