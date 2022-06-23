package com.pragma.usermanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.pragma.usermanager.application.dto.PersonDTO;
import com.pragma.usermanager.domain.entity.PersonEntity;
import com.pragma.usermanager.domain.entity.ProfileEntity;

@SpringBootTest
public class PersonMapperTests {
	
	private PersonEntity person1Entity;
	private PersonDTO person1DTO;
	
	@BeforeTestClass
	public void initializeObjects() {
		Date date = new Date();
		person1Entity = new PersonEntity();
		person1Entity.setId(10);
		person1Entity.setName("Prueba");
		person1Entity.setEmail("prueba@prueba.com");
		person1Entity.setImage(null);
		person1Entity.setCityId(null);
		person1Entity.setProfileId(new ProfileEntity(1));
		person1Entity.setCreateDate(date);
		person1Entity.setUpdateDate(date);
		
		person1DTO = PersonDTO.builder()
				.id(10)
				.name("Prueba")
				.email("prueba@prueba.com")
				.image(null)
				.cityId(0)
				.cityName(null)
				.profileId(1)
				.profileName("Desarrollador de software")
				.createDate(date)
				.updateDate(date)
				.build();
	}

	@Test
	public void convertPersonEntityToPersonDto() {
		PersonDTO personDTO = PersonDTO.builder()
				.build();
		
		assertEquals(personDTO, person1DTO);
	}
	
	@Test
	public void convertPersonDtoToPersonEntity() {
		
	}
	
}
