package com.promineo.pets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
/*
 * this my exception that handles any issues with objects not existing in the database
 * for example, if you call a key that does not exist this exception is used 
 */
public class ResourceNotFoundException extends RuntimeException{
	private String resourceName;
	private String fieldName;
	
	//object, because it can be any type
	private Object fieldValue;
	
	public ResourceNotFoundException(
			String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", 
				resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
}
