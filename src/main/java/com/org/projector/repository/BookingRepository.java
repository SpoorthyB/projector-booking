package com.org.projector.repository;

import com.org.projector.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking,Long>{
	
	//find all bookings for a team
	List<Booking> findBookingByTeam(String team);
	
	//find all bookings for a projector
	List<Booking> findBookingByProjector(String projector);
	
	@Query("{'date':?0,{$and[{'start':{$lte : ?2}},{'end':{$gte : ?1}}]}")
	List<Booking> FindOverlappingBookings(LocalDate date, LocalDateTime start,LocalDateTime end,Sort sort);
	
	//find for a given date, start, end times
	Booking findBookingByDateAndStartAndEnd(LocalDate date, LocalDateTime start,LocalDateTime end);
	
	//find by date
	List<Booking> findBookingByDate(LocalDate date);
	

}
