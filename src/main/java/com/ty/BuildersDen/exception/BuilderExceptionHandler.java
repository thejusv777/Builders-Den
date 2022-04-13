package com.ty.BuildersDen.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class BuilderExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			
		Map<String, String> errorlist=new LinkedHashMap<String, String>();
		List<ObjectError >  error =ex.getAllErrors();
		for(ObjectError error2:error) {
			String message=error2.getDefaultMessage();
			FieldError fieldError= (FieldError) error2;
			errorlist.put(fieldError.getField(), message);
		}
		
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	
}
