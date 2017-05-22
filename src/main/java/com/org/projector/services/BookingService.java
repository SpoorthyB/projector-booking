package com.org.projector.services;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.projector.beans.Booking;
import com.org.projector.exception.ResourceNotFoundException;
import com.org.projector.repository.BookingRepository;
import com.org.projector.util.SchedulerUtility;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingrepo;
	@Autowired
	SchedulerService schedulerService;
	@Autowired
	SchedulerUtility util;
	
	public List<Booking> findBookingByTeam(String team){
		return (List<Booking>) bookingrepo.findBookingByTeam(team);
	}
	
	public List<Booking> findBookingByProjector(String projector){
		return (List<Booking>) bookingrepo.findBookingByProjector(projector);
	}
	
	public List<Booking> getConflictingBookings(String date, String starttime, String endtime){
		List<Booking> bList = (List<Booking>)bookingrepo.findBookingByDate(date)/*,new Sort(Sort.Direction.DESC,"id")*/;
		List<Booking> overlaps = new ArrayList<Booking>();
		Date indate = util.getDateFromString(date);
		Date instart = util.getTimeFromString(starttime);
		Date inend = util.getTimeFromString(endtime);
		for(Booking booking: bList){
			Date day = util.getDateFromString(booking.getDate());
			Date start = util.getTimeFromString(booking.getStart());
			Date end = util.getTimeFromString(booking.getEnd());
			if(indate.equals(day)){
				if(!start.after(instart)&&!end.before(instart)||!start.after(inend)&&!end.before(inend)){
					overlaps.add(booking);
				}
			}
		}
		return overlaps;		
	}
	
	public void createBooking(Booking booking){
		bookingrepo.save(booking);
	}
	
	public Booking getBooking(String date, String starttime, String endtime){
		Booking bookingObj = bookingrepo.findBookingByDateAndStartAndEnd(date, starttime, endtime);
		if(bookingObj == null){
			throw new ResourceNotFoundException();
		}
		return bookingObj;
	}
	
	public List<Booking> getBookingbyDate(String date){
		List<Booking> bookingObj = bookingrepo.findBookingByDate(date);
		if(bookingObj == null){
			throw new ResourceNotFoundException();
		}
		return bookingObj;
	}
	
	public Booking getBookingById(String id){
		return bookingrepo.findOne(id);
	}
	
	public void updateBooking(Booking booking){
		Booking updateBooking = getBooking(booking.getDate(),booking.getStart(),booking.getEnd());
		if (updateBooking == null) {
			throw new ResourceNotFoundException();
		}
		bookingrepo.save(booking);
	}
	
	public void cancelBooking(Booking booking){
		bookingrepo.delete(booking);
	}

	public Booking createBooking(String date, String start, String end, String team) {
		
		List<String> availableProjectors = getAvailableProjectors(date, start, end);
		if(availableProjectors.size() ==0){
			return null;
		}
		String assignProjector = availableProjectors.get(0);
		availableProjectors.remove(0);
		return new Booking(date, start, end, assignProjector,team);
		
	}

	private List<String> getAvailableProjectors(String date, String start, String end) {
		List<String> allProjectors = schedulerService.getAllProjectorIds();
		List<Booking> dateBookings = getConflictingBookings(date, start, end);
		List<String> bookedProjectors = schedulerService.getProjectorIdsFromBookings(dateBookings);
		
		//return all projectors if overlapping bookings not found
		if(bookedProjectors == null||bookedProjectors.size() == 0)return allProjectors;
		
		/*SchedulerUtility util = new SchedulerUtility();*/
		List<String> availableProjectors = util.findDifference(allProjectors, bookedProjectors);
		return availableProjectors;
	}
}
