package com.max.project.manager.factories;


import org.apache.commons.lang3.time.StopWatch;

import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;

public abstract class MainAbstractFactory {
	
	public abstract Worker getWorker(String worker);

	public abstract Work getWork(String work);
	
	public abstract Project getProject(String project);

	public abstract Customer getCustomer(String customer);

	public abstract StopWatch getStopWatch(String stopWatch);
}
