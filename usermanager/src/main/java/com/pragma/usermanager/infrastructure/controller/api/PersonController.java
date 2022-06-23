package com.pragma.usermanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.usermanager.model.dto.ResponseDTO;
import com.pragma.usermanager.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonReadController {
	
	private final PersonService personService;
	    
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
