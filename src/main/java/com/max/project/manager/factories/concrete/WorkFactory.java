package com.max.project.manager.factories.concrete;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.AtomicJob;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.exceptions.ObjectNotFoundException;
import com.max.project.manager.factories.MainAbstractFactory;

public class WorkFactory extends MainAbstractFactory {
	private static final WorkFactory workFactory = new WorkFactory();
	
	private WorkFactory() {}
	
	// lazy, thread-safe singleton implementation
	public static WorkFactory getInstance() {
		return workFactory;
	}
	
	public Work getWork(String type) {
		switch(type) {
		case "atomicJob":
			return new AtomicJob();
		default:
			throw new ObjectNotFoundException("Could not find work: " + type);
		}
	}

	@Override
	public Worker getWorker(String worker) {
		return null;
	}

	@Override
	public Project getProject(String project) {
		return null;
	}

	@Override
	public Customer getCustomer(String customer) {
		return null;
	}

	@Override
	public StopWatch getStopWatch(String stopWatch) {
		return null;
	}
}
