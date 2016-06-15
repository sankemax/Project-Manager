package com.max.project.manager.beans.abstractclasses;

import java.util.Date;

public abstract class AbstractWork {

	private Long id;
	private Long customerId;
	private Long projectId;
	private String name;
	private String description;
	private Date dateOfStart;
	private Date dateOfEnd;
	private String comments;
	private Boolean finished;
	private Boolean canceled;
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public Date getDateOfEnd() {
		return dateOfEnd;
	}
	public void setDateOfEnd(Date dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	public Boolean getCanceled() {
		return canceled;
	}
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}
}
