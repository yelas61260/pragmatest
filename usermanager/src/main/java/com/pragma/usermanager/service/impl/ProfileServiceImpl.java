package com.pragma.usermanager.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.usermanager.model.entity.ProfileEntity;
import com.pragma.usermanager.repository.RepositoryProfile;
import com.pragma.usermanager.service.ProfileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final RepositoryProfile repositoryProfile;
	
	@Override
	public boolean exist(int profileId) {
		Optional<ProfileEntity> profileEntity = this.repositoryProfile.findById(profileId);
		return !profileEntity.isEmpty();
	}

}
