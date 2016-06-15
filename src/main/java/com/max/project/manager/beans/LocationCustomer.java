package com.max.project.manager.beans;

import com.max.project.manager.beans.interfaces.Customer;

public class LocationCustomer extends SimpleCustomer implements Customer {

	private String city;
	private String street;
	private String houseNum;
	
	public LocationCustomer() {}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	
}
