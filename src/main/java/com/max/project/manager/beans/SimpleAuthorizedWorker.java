package com.max.project.manager.beans;

import java.util.List;

import com.max.project.manager.beans.abstractclasses.AbstractWorker;
import com.max.project.manager.beans.interfaces.AutorizedWorker;
import com.max.project.manager.beans.interfaces.Worker;

public class SimpleAuthorizedWorker extends AbstractWorker implements Worker, AutorizedWorker {

	private List<Worker> workers;

	public List<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewWorks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewWorkers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unFinish() {
		// TODO Auto-generated method stub

	}

}
