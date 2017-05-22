package com.org.projector.util;

import java.util.List;

public class SchedulerUtility {
	
	public List<String> findDifference(List<String> l1,List<String> l2){
		
		l1.removeAll(l2);
		return l1;
	}

}
