package com.org.projector.repository;

import com.org.projector.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking,String>{
	
	//find all bookings for a team
	List<Booking> findBookingByTeam(String team);
	
	//find all bookings for a projector
	List<Booking> findBookingByProjector(String projector);
	
	//@Query("{'date':?0,{$or[{$and[{'start':{$gte : ?1}},{'end':{$lte : ?1}}]}, {$and[{'start':{$gte : ?2}},{'end':{$lte : ?2}}]}]}")
	//List<Booking> FindOverlappingBookings(LocalDate date, LocalDateTime start,LocalDateTime end,Sort sort);
	
	//find for a given date, start, end times
	Booking findBookingByDateAndStartAndEnd(String date, String start,String end);
	
	//find by date
	List<Booking> findBookingByDate(String date);
	

}
