package com.org.projector.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.projector.beans.Projector;

public interface ProjectorRepository extends CrudRepository<Projector,String>{

	List<Projector> findAllByOrderByIdAsc();
	
	
}
