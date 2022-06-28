package com.pragma.usermanager.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.usermanager.application.mapper.PersonEntityWithDtoMapper;
import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.application.service.ProfileService;
import com.pragma.usermanager.application.service.impl.CityServiceImpl;
import com.pragma.usermanager.application.service.impl.PersonServiceImpl;
import com.pragma.usermanager.application.service.impl.PersonValidatorServiceImpl;
import com.pragma.usermanager.application.service.impl.ProfileServiceImpl;
import com.pragma.usermanager.infrastructure.db.repository.CityRepository;
import com.pragma.usermanager.infrastructure.db.repository.PersonRepository;
import com.pragma.usermanager.infrastructure.db.repository.ProfileRepository;

@Configuration
public class BeanApplicationConfiguration {
	
	@Bean
	public CityServiceImpl cityService(CityRepository cityRepository) {
		return new CityServiceImpl(cityRepository);
	}
	
	@Bean
	public ProfileServiceImpl profileService(ProfileRepository profileRepository) {
		return new ProfileServiceImpl(profileRepository);
	}
	
	@Bean
	public PersonServiceImpl personService(PersonRepository personRepository, PersonValidatorService personValidatorService) {
		return new PersonServiceImpl(personRepository, personValidatorService);
	}
	
	@Bean
	public PersonValidatorServiceImpl personValidatorService(CityService cityService, ProfileService profileService, PersonEntityWithDtoMapper personEntityWithDtoMapper) {
		return new PersonValidatorServiceImpl(cityService, profileService, personEntityWithDtoMapper);
	}

}
