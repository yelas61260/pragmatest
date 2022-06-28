package com.pragma.usermanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.usermanager.infrastructure.db.entity.ProfileMySqlEntity;

@SpringBootTest
public class PersonMapperTests {
	
	private PersonMySqlEntity person1Entity;
	private PersonDTO person1DTO;
	
	@BeforeTestClass
	public void initializeObjects() {
		Date date = new Date();
		person1Entity = new PersonMySqlEntity();
		person1Entity.setId(10);
		person1Entity.setName("Prueba");
		person1Entity.setEmail("prueba@prueba.com");
		person1Entity.setImage(null);
		person1Entity.setCityId(null);
		person1Entity.setProfileId(ProfileMySqlEntity.builder().id(1).build());
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
