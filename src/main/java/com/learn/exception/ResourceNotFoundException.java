package com.learn.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;


	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		                 //resource  not found this name and id
		this.resourceName = resourceName;
		this.fieldName = fieldName;                                                                                               
		this.fieldValue = fieldValue;
	}

}
