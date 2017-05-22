package com.org.projector.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.projector.beans.Booking;
import com.org.projector.beans.Projector;
import com.org.projector.beans.RequestQueue;
import com.org.projector.services.*;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(method=RequestMethod.GET, value="/booking/{date}")
	public List<Booking> createBooking(@PathVariable("date") 
    		String date, HttpServletResponse response) {
		
		return bookingService.getBookingbyDate(date);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/booking/{team}")
	public List<Booking> getBookings(@PathVariable String team){
		return bookingService.findBookingByTeam(team);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/projectorbooking")
	public void postBooking(@RequestBody Booking obj,  HttpServletResponse response) {
		bookingService.createBooking(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/booking/team/{team}")
	public Booking createBooking(@PathVariable String team, 
			@RequestParam String date,
			@RequestParam /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)*/ String start,
			@RequestParam String end,
			HttpServletResponse response) {
		
		Booking record = bookingService.createBooking(date,start,end,team);
		if(record!=null){
			bookingService.createBooking(record);
		}
		return record;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/booking/{id}")
	public void cancelBooking(String id){
		bookingService.cancelBooking(bookingService.getBookingById(id));
	}
	
	

}
