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
    private long id;
	private LocalDate date;
	private LocalDateTime start;
	private LocalDateTime end;	
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
	public Booking(LocalDate date, LocalDateTime start, LocalDateTime end, String projector, String team) {
		super();
		this.date = date;
		this.start = start;
		this.end = end;
		this.projector = projector;
		this.team = team;
	}
	
	/* Getters and Setters*/
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
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
