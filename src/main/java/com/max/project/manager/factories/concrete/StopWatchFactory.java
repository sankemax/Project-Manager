package com.max.project.manager.factories.concrete;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.ConcreteTimer;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.exceptions.FactoryNotFoundException;
import com.max.project.manager.factories.MainAbstractFactory;

public class StopWatchFactory extends MainAbstractFactory {
	private static final StopWatchFactory stopWatchFactory = new StopWatchFactory();
	
	private StopWatchFactory() {}
	
	public static StopWatchFactory getInstance() {
		return stopWatchFactory;
	}
	
	@Override
	public StopWatch getStopWatch(String type) {
		switch(type) {
		case "concreteTimer":
			return new ConcreteTimer();
		default:
			throw new FactoryNotFoundException("Could not find stopwatch: " + type);
		}
	}

	@Override
	public Worker getWorker(String worker) {
		return null;
	}

	@Override
	public Work getWork(String work) {
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
}
