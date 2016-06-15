package com.max.project.manager.factories;

import com.max.project.manager.exceptions.FactoryNotFoundException;
import com.max.project.manager.factories.concrete.CustomerFactory;
import com.max.project.manager.factories.concrete.ProjectFactory;
import com.max.project.manager.factories.concrete.StopWatchFactory;
import com.max.project.manager.factories.concrete.WorkFactory;
import com.max.project.manager.factories.concrete.WorkerFactory;

public class FactoryProducer {

	public static MainAbstractFactory getFactory(String factory) {
		switch(factory) {
		case "customer":
			return CustomerFactory.getInstance();
		case "project":
			return ProjectFactory.getInstance();
		case "stopwatch":
			return StopWatchFactory.getInstance();
		case "worker":
			return WorkerFactory.getInstance();
		case "work":
			return WorkFactory.getInstance();
		default:
			throw new FactoryNotFoundException("Could not find factory: " + factory);
		}
	}
}
