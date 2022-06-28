package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.service.ProfileService;
import com.pragma.usermanager.infrastructure.db.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileRepository profileRepository;
	
	@Override
	public boolean exist(int profileId) {
		return profileRepository.exist(profileId);
	}

}
