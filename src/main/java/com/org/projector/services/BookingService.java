package com.org.projector.services;

import java.time.*;
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
	
	public List<Booking> findBookingByTeam(String team){
		return (List<Booking>) bookingrepo.findBookingByTeam(team);
	}
	
	public List<Booking> findBookingByProjector(String projector){
		return (List<Booking>) bookingrepo.findBookingByProjector(projector);
	}
	
	public List<Booking> getConflictingBookings(LocalDate date, LocalDateTime starttime, LocalDateTime endtime){
		return (List<Booking>)bookingrepo.FindOverlappingBookings(date, starttime, endtime,new Sort(Sort.Direction.DESC,"id"));
	}
	
	public void createBooking(Booking booking){
		bookingrepo.save(booking);
	}
	
	public Booking getBooking(LocalDate date, LocalDateTime starttime, LocalDateTime endtime){
		Booking bookingObj = bookingrepo.findBookingByDateAndStartAndEnd(date, starttime, endtime);
		if(bookingObj == null){
			throw new ResourceNotFoundException();
		}
		return bookingObj;
	}
	
	public Booking getBookingById(Long id){
		return bookingrepo.findOne(id);
	}
	
	public void updateBooking(Booking booking){
		Booking updateBooking = getBooking(booking.getDate(),booking.getStart(),booking.getEnd());
		updateBooking.setDate(booking.getDate());
		updateBooking.setStart(booking.getStart());
		updateBooking.setEnd(booking.getEnd());
		updateBooking.setTeam(booking.getTeam());
		updateBooking.setProjector(booking.getProjector());
		bookingrepo.save(updateBooking);
	}
	
	public void cancelBooking(Booking booking){
		bookingrepo.delete(booking);
	}

	public Booking createBooking(LocalDate date, LocalDateTime start, LocalDateTime end, String team) {
		
		List<String> availableProjectors = getAvailableProjectors(date, start, end);
		if(availableProjectors.size() ==0){
			return null;
		}
		String assignProjector = availableProjectors.get(0);
		availableProjectors.remove(0);
		return new Booking(date, start, end, assignProjector,team);
		
	}

	private List<String> getAvailableProjectors(LocalDate date, LocalDateTime start, LocalDateTime end) {
		List<String> allProjectors = schedulerService.getAllProjectorIds();
		List<Booking> dateBookings = getConflictingBookings(date, start, end);
		List<String> bookedProjectors = schedulerService.getProjectorIdsFromBookings(dateBookings);
		
		//return all projectors if overlapping bookings not found
		if(bookedProjectors == null)return allProjectors;
		
		SchedulerUtility util = new SchedulerUtility();
		List<String> availableProjectors = util.findDifference(allProjectors, bookedProjectors);
		return availableProjectors;
	}
}
