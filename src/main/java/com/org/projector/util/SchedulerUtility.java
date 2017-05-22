package com.org.projector.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SchedulerUtility {
	
	public List<String> findDifference(List<String> l1,List<String> l2){
		
		for(String s: l1){
			System.out.print(s + ",");
		}
		System.out.println();
		for(String s: l2){
			System.out.print(s + ",");
		}
		
		
		l1.removeAll(l2);
		return l1;
	}
	
	
	public Date getDateFromString(String date){
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		try {
		    Date userDate = parser.parse(date);
		    return userDate;
		} catch (ParseException e) {
		    // Invalid date was entered
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Date getTimeFromString(String date){
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		try {
		    Date userDate = parser.parse(date);
		    return userDate;
		} catch (ParseException e) {
		    // Invalid date was entered
			System.out.println(e.getMessage());
		}
		return null;
	}

}
