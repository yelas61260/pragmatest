package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.service.ProfileService;
import com.pragma.usermanager.domain.service.ProfileDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileDomainService profileDomainService;
	
	@Override
	public boolean exist(int profileId) {
		return profileDomainService.exist(profileId);
	}

}
