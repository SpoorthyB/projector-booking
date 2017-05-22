package com.org.projector.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.projector.beans.Projector;
import com.org.projector.beans.RequestQueue;
import com.org.projector.repository.RequestQueueRepository;

@Service
public class RequestQueueService {
	
	//Queue of Requests not fulfilled
	@Autowired
	private RequestQueueRepository requestQueue;
	
	public List<RequestQueue> getAll(){
		List<RequestQueue> projectorList =  (List<RequestQueue>) requestQueue.findAllByOrderByCreatedDesc();				
		return projectorList;
	}
	
	public void createRequest(RequestQueue request){
		requestQueue.save(request);
	}
	
	

}
