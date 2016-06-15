package com.max.project.manager.factories.concrete;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.SimpleAuthorizedWorker;
import com.max.project.manager.beans.SimpleRegularWorker;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.exceptions.ObjectNotFoundException;
import com.max.project.manager.factories.MainAbstractFactory;

public class WorkerFactory extends MainAbstractFactory {

	private static final WorkerFactory workerFactory = new WorkerFactory();
	
	private WorkerFactory() {}
	
	public static WorkerFactory getInstance() {
		return workerFactory;
	}
	
	public Worker getWorker(String type) {
		switch(type) {
		case "simpleWorker":
			return new SimpleRegularWorker();
		case "autorizedWorker":
			return new SimpleAuthorizedWorker();
		default:
			throw new ObjectNotFoundException("Could not find object: " + type);
		}
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

	@Override
	public StopWatch getStopWatch(String stopWatch) {
		return null;
	}
}
