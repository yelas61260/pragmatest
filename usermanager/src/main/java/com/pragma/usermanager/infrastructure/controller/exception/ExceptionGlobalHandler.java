package com.pragma.usermanager.infrastructure.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pragma.usermanager.application.dto.response.ResponseDTO;
import com.pragma.usermanager.application.exception.conflict.UserManagerConflictException;
import com.pragma.usermanager.application.exception.notfound.UserManagerNotFoundException;

@ControllerAdvice
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(RuntimeException e) {
		ResponseDTO response = new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> exception(Exception e) {
		ResponseDTO response = new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserManagerNotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(UserManagerNotFoundException e){
		ResponseDTO response = new ResponseDTO(null, HttpStatus.NOT_FOUND.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserManagerConflictException.class)
	public ResponseEntity<ResponseDTO> conflictException(UserManagerConflictException e){
		ResponseDTO response = new ResponseDTO(null, HttpStatus.CONFLICT.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.CONFLICT);
	}

}
