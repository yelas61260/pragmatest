package com.pragma.usermanager.infrastructure.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.application.dto.response.ResponseDTO;
import com.pragma.usermanager.application.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
	
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
	    
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllPerson() {
		ResponseDTO response = new ResponseDTO(personService.getAll(), HttpStatus.OK.value(), "success");
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<ResponseDTO> getPersonById(@PathVariable("personId") int personId){
		ResponseDTO response = new ResponseDTO(personService.getById(personId), HttpStatus.OK.value(), "success");
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    
}
