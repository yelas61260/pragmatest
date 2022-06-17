package com.pragma.usermanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.usermanager.model.dto.PersonDTO;
import com.pragma.usermanager.model.dto.ResponseDTO;
import com.pragma.usermanager.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonWriteController {
	
	private final PersonService personService;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDTO> create(@RequestBody PersonDTO person) {
		ResponseDTO response = new ResponseDTO(personService.create(person), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDTO> update(@RequestBody PersonDTO person) {
		ResponseDTO response = new ResponseDTO(personService.update(person), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
    
}
