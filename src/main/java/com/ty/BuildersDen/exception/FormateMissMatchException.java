package com.ty.BuildersDen.exception;

public class FormateMissMatchException extends RuntimeException{
	
	private String message;
	
	public FormateMissMatchException(){
		
	}
	 
	public FormateMissMatchException(String messahe){
		this.message =message;
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	

}
