package com.max.project.manager.beans;

import org.apache.commons.lang3.time.StopWatch;

public class ConcreteTimer extends StopWatch {

	private long id;
	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ConcreteTimer [id=" + id + ", getTime()=" + getTime() + ", getStartTime()=" + getStartTime() + "]";
	}

	
}
