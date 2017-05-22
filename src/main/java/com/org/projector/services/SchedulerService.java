package com.org.projector.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.projector.beans.Booking;
import com.org.projector.beans.Projector;

@Service
public class SchedulerService {
	
	@Autowired
	ProjectorService projService;
	
	public List<String> getAllProjectorIds(){
		List<Projector> projectorList =  projService.getAll();
		List<String> projectorIds = projectorList.stream().map(Projector::getId).collect(Collectors.toList());
		return projectorIds;
	}

	public List<String> getProjectorIdsFromBookings(List<Booking> dateBookings) {
		
		List<String> projectorIds = dateBookings.stream().map(Booking::getProjector).collect(Collectors.toList());
		return projectorIds;
	}
	

}
