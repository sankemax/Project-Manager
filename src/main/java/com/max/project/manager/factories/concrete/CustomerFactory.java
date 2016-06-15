package com.max.project.manager.factories.concrete;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.LocationCustomer;
import com.max.project.manager.beans.SimpleCustomer;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.exceptions.ObjectNotFoundException;
import com.max.project.manager.factories.MainAbstractFactory;

public class CustomerFactory extends MainAbstractFactory {
	
	private static final CustomerFactory customerFactory = new CustomerFactory();
	
	private CustomerFactory() {}
	
	public static CustomerFactory getInstance() {
		return customerFactory;
	}
	
	@Override
	public Customer getCustomer(String type) {
		switch(type) {
		case "simpleCustomer":
			return (Customer) new SimpleCustomer();
		case "locationCustomer":
			return (Customer) new LocationCustomer();
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
	public Project getProject(String project) {
		return null;
	}

	@Override
	public StopWatch getStopWatch(String stopWatch) {
		return null;
	}
}
