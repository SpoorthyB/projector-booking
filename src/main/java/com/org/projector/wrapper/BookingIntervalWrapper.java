package com.org.projector.wrapper;

import java.time.LocalDateTime;

public class BookingIntervalWrapper {
	private LocalDateTime starttime;
	private LocalDateTime endtime;
	
	public BookingIntervalWrapper(){}
	
	public BookingIntervalWrapper(LocalDateTime starttime, LocalDateTime endtime) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public LocalDateTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}

	public LocalDateTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}
	
	

}
