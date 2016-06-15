package com.max.project.manager.beans.interfaces;

public interface AutorizedWorker extends Worker {
	
	public void create();
	public void cancel();
	public void unCancel();
	public void viewWorks();
	public void viewWorkers();
}
