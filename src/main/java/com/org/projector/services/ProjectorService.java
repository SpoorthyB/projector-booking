package com.org.projector.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.org.projector.beans.Projector;
import com.org.projector.exception.ResourceNotFoundException;
import com.org.projector.repository.ProjectorRepository;

@Service
public class ProjectorService {
	
	
	private ProjectorRepository repository;
	
	@Autowired
	public ProjectorService(ProjectorRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Projector> getAll(){
		List<Projector> projectorList =  (List<Projector>) repository.findAllByOrderByIdAsc();				
		return projectorList;
	}	
	

	public Projector getProjector(String id){
		Projector projector = repository.findOne(id);
		if (projector == null) {
			throw new ResourceNotFoundException();
		}
		return projector;
	}
	
	public void updateProjector(String id, Projector p){
		Projector projector = repository.findOne(id);
		if (projector == null) {
			throw new ResourceNotFoundException();
		}
		projector.setId(p.getId());
		projector.setName(p.getName());
		projector.setDescription(p.getDescription());
		repository.save(projector);
	}
	
	public Projector createProjector(Projector proj){
		repository.save(proj);
		return proj;
	}

	public void deleteProjector(String id) {
		Projector projector = repository.findOne(id);
		if (projector == null) {
			throw new ResourceNotFoundException();
		}
		repository.delete(projector);
		
	}
	

}
