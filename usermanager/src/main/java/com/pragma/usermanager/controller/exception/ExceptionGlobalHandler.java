package com.pragma.usermanager.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pragma.usermanager.model.dto.ResponseDTO;
import com.pragma.usermanager.model.exception.*;

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
	
	@ExceptionHandler(UserManagerException.class)
	public ResponseEntity<ResponseDTO> notFoundException(UserManagerException e){
		ResponseDTO response = new ResponseDTO(null, HttpStatus.NOT_FOUND.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.NOT_FOUND);
	}

}
