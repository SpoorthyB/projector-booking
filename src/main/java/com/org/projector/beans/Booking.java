package com.org.projector.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndexes({
    @CompoundIndex(name = "date_idx", def = "{'date': 1, 'start': 1, 'end': 1}")
})
public class Booking {
	
	@Id
    private String id;
	private String date;
	private String start;
	private String end;	
	private String projector;
	@Indexed
	private String team;
	
	
	public Booking(){};
	/**
	 * @param date
	 * @param start
	 * @param end
	 * @param projector
	 * @param team
	 */
	public Booking(String date, String start, String end, String projector, String team) {
		super();
		this.date = date;
		this.start = start;
		this.end = end;
		this.projector = projector;
		this.team = team;
	}
	public Booking(String id,String date, String start, String end, String projector, String team) {
		super();
		this.id = id;
		this.date = date;
		this.start = start;
		this.end = end;
		this.projector = projector;
		this.team = team;
	}
	
	/* Getters and Setters*/
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getProjector() {
		return projector;
	}
	public void setProjector(String projector) {
		this.projector = projector;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	

}
