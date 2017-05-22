package com.org.projector.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.projector.services.ProjectorService;
import com.org.projector.beans.*;

@RestController
public class ProjectorController {
	
	@Autowired
	private ProjectorService projectorService;
	
	@RequestMapping(method=RequestMethod.GET, value="/projectors")
	public List<Projector> getAllProjectors(){
		return projectorService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/projectors/{id}")
	public Projector getProjector(@PathVariable String id, HttpServletResponse response){
		return projectorService.getProjector(id);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/projectors/{id}")
	public void updateProjector(@PathVariable String id,@RequestBody Projector obj){
		projectorService.updateProjector(id, obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/projectors")
	public Projector postProjector(@RequestBody Projector obj,  HttpServletResponse response) {
		return projectorService.createProjector(obj);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/projectors/{id}")
	public void deleteProjector(@PathVariable String id){
		projectorService.deleteProjector(id);
	}
	
}
