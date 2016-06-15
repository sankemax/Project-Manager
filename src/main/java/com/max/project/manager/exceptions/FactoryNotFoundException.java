package com.max.project.manager.exceptions;

public class FactoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FactoryNotFoundException() {}

	public FactoryNotFoundException(String message) {
		super(message);
	}
}
