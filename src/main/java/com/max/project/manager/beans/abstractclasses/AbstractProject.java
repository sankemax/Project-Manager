package com.max.project.manager.beans.abstractclasses;

import java.util.Date;
import java.util.List;

import com.max.project.manager.beans.interfaces.Work;

public abstract class AbstractProject {
	
	private long id;
	private String name;
	private String description;
	private String comments;
	private Date startDate;
	private Date closeDate;
	private boolean isFinished;
	private boolean isCanceled;
	private List<Work> works;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	public boolean isCanceled() {
		return isCanceled;
	}
	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Work> getWorks() {
		return works;
	}
	public void setWorks(List<Work> works) {
		this.works = works;
	}
	public void addWork(Work work) {
		works.add(work);
	}
	public void addWork(List<Work> works) {
		works.addAll(works);
	}
}
