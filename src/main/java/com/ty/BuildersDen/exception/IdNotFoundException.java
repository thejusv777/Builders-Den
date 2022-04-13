package com.ty.BuildersDen.exception;

public class IdNotFoundException extends RuntimeException{
	
	private String message="id Not found";
	
	IdNotFoundException(){
		
	}
	public IdNotFoundException(String messagr){
		this .message=messagr;
	}
	@Override
	public String getMessage() {
		return  message;
	}
	

}
