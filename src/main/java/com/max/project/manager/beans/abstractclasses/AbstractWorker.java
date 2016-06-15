package com.max.project.manager.beans.abstractclasses;

import java.util.List;

import com.max.project.manager.beans.interfaces.Work;

public abstract class AbstractWorker {

	private long id;
	private String name;
	private String password;
	private List<Work> works;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Work> getWorks() {
		return works;
	}
	public void setWorks(List<Work> works) {
		this.works = works;
	}
	public long getId() {
		return id;
	}	
}
