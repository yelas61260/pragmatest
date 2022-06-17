package com.pragma.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pragma.usermanager.person.domain.dto.PersonDTO;
import com.pragma.usermanager.person.domain.entity.PersonEntity;
import com.pragma.usermanager.person.domain.mapper.PersonMapper;

@SpringBootApplication
public class UsermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagerApplication.class, args);
	}

}
