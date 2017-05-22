package com.org.projector.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.projector.beans.Projector;
import com.org.projector.beans.RequestQueue;

public interface RequestQueueRepository extends CrudRepository<RequestQueue,Long>{
	
	List<RequestQueue> findAllByOrderByCreatedDesc();

}
