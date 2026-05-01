package com.example.Banking_Application.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public String fieldName;
	public long fieldId;
	public String resourceName;
	
	public ResourceNotFoundException(String fieldName, String resourceName, long fieldId) {
		this.fieldName = fieldName;
		this.resourceName = resourceName;
		this.fieldId = fieldId;
	}
	@Override
	public String getMessage() {
		return resourceName+"not found for"+fieldName+"="+fieldId;
	}

}
