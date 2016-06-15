package com.max.project.manager.factories.concrete;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.SimpleProject;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.exceptions.ObjectNotFoundException;
import com.max.project.manager.factories.MainAbstractFactory;

public class ProjectFactory extends MainAbstractFactory {

	private static final ProjectFactory projectFactory = new ProjectFactory();
	
	private ProjectFactory() {}
	
	public static ProjectFactory getInstance() {
		return projectFactory;
	}
	
	@Override
	public Project getProject(String type) {
		switch(type) {
		case "simpleProject":
			return new SimpleProject();
		default:
			throw new ObjectNotFoundException("Could not find project: " + type);
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
	public Customer getCustomer(String customer) {
		return null;
	}

	@Override
	public StopWatch getStopWatch(String stopWatch) {
		return null;
	}
}
