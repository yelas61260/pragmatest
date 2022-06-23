package com.pragma.usermanager.domain.service.impl;

import com.pragma.usermanager.domain.repository.ProfileRepository;
import com.pragma.usermanager.domain.service.ProfileDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfileDomainServiceImpl implements ProfileDomainService {
	
	private final ProfileRepository profileRepository;
	
	@Override
	public boolean exist(int profileId) {
		return profileRepository.exist(profileId);
	}

}
