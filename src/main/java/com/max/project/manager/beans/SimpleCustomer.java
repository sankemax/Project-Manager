package com.max.project.manager.beans;

import com.max.project.manager.beans.abstractclasses.AbstractCustomer;
import com.max.project.manager.beans.interfaces.Customer;

public class SimpleCustomer extends AbstractCustomer implements Customer {

	private String phone;
	private String email;
	
	public SimpleCustomer() {}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
