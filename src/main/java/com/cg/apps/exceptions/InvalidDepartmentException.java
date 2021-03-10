package com.cg.apps.exceptions;

public class InvalidDepartmentException extends RuntimeException{
	public InvalidDepartmentException(String msg) {
		super(msg);
	}
}
