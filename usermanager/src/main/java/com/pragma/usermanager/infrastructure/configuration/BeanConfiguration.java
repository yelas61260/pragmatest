package com.pragma.usermanager.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.usermanager.application.mapper.PersonMapper;
import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.application.service.ProfileService;
import com.pragma.usermanager.application.service.impl.CityServiceImpl;
import com.pragma.usermanager.application.service.impl.PersonServiceImpl;
import com.pragma.usermanager.application.service.impl.PersonValidatorServiceImpl;
import com.pragma.usermanager.application.service.impl.ProfileServiceImpl;
import com.pragma.usermanager.domain.repository.CityRepository;
import com.pragma.usermanager.domain.repository.PersonRepository;
import com.pragma.usermanager.domain.repository.ProfileRepository;
import com.pragma.usermanager.domain.service.CityDomainService;
import com.pragma.usermanager.domain.service.PersonDomainService;
import com.pragma.usermanager.domain.service.ProfileDomainService;
import com.pragma.usermanager.domain.service.impl.CityDomainServiceImpl;
import com.pragma.usermanager.domain.service.impl.PersonDomainServiceImpl;
import com.pragma.usermanager.domain.service.impl.ProfileDomainServiceImpl;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public CityServiceImpl cityService(CityDomainService cityDomainService) {
		return new CityServiceImpl(cityDomainService);
	}
	
	@Bean
	public ProfileServiceImpl profileService(ProfileDomainService profileDomainService) {
		return new ProfileServiceImpl(profileDomainService);
	}
	
	@Bean
	public PersonServiceImpl personService(PersonDomainService personDomainService, PersonValidatorService personValidatorService, PersonMapper personMapper) {
		return new PersonServiceImpl(personDomainService, personValidatorService, personMapper);
	}
	
	@Bean
	public PersonValidatorServiceImpl personValidatorService(PersonDomainService personDomainService, CityService cityService, ProfileService profileService) {
		return new PersonValidatorServiceImpl(personDomainService, cityService, profileService);
	}
	
	@Bean
	public CityDomainServiceImpl cityDomainService(CityRepository cityRepository) {
		return new CityDomainServiceImpl(cityRepository);
	}
	
	@Bean
	public ProfileDomainServiceImpl profileDomainService(ProfileRepository profileRepository) {
		return new ProfileDomainServiceImpl(profileRepository);
	}
	
	@Bean
	public PersonDomainServiceImpl personDomainService(PersonRepository personRepository) {
		return new PersonDomainServiceImpl(personRepository);
	}

}
