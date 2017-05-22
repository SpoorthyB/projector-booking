package com.org.projector.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.projector.beans.Booking;
import com.org.projector.beans.Projector;
import com.org.projector.beans.RequestQueue;
import com.org.projector.services.*;

public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(method=RequestMethod.POST, value="/projectorbooking")
	public void postBooking(@RequestBody Booking obj,  HttpServletResponse response) {
		bookingService.createBooking(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/booking")
	public Booking createBooking(@RequestBody RequestQueue request,HttpServletResponse response) {
		
		return bookingService.createBooking(request.getDate(),request.getStart(),request.getEnd(),request.getTeam());
	}
	
	

}
