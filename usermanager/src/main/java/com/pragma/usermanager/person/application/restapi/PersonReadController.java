package com.pragma.usermanager.person.application.restapi;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.usermanager.person.domain.dto.PersonDTO;
import com.pragma.usermanager.person.domain.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonReadController {
	
	private final PersonService personService;
	    
    @GetMapping("/all")
    public List<PersonDTO> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{personId}")
    public PersonDTO getPersonById(@PathVariable("personId") int personId){
        return personService.getPersonById(personId);
    }
    
}
