package com.cg.apps.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}