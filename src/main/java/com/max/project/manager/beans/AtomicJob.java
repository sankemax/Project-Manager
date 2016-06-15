package com.max.project.manager.beans;

import com.max.project.manager.beans.abstractclasses.AbstractWork;
import com.max.project.manager.beans.interfaces.Work;

public class AtomicJob extends AbstractWork implements Work {
	
	private Double unitWorth;
	private Integer numOfUnits;
	
	public Double getUnitWorth() {
		return unitWorth;
	}
	public void setUnitWorth(Double unitWorth) {
		this.unitWorth = unitWorth;
	}
	public Integer getNumOfUnits() {
		return numOfUnits;
	}
	public void setNumOfUnits(Integer numOfUnits) {
		this.numOfUnits = numOfUnits;
	}
}
