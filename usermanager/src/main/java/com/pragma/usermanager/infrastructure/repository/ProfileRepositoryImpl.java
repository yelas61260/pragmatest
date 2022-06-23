package com.pragma.usermanager.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.domain.entity.ProfileEntity;
import com.pragma.usermanager.domain.repository.ProfileRepository;
import com.pragma.usermanager.infrastructure.dao.ProfileDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {
	
	private final ProfileDao profileDao;
	
	@Override
	public boolean exist(int profileId) {
		Optional<ProfileEntity> profileEntity = this.profileDao.findById(profileId);
		return !profileEntity.isEmpty();
	}

}
