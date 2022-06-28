package com.pragma.usermanager.infrastructure.db.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.infrastructure.db.dao.ProfileDao;
import com.pragma.usermanager.infrastructure.db.entity.ProfileMySqlEntity;
import com.pragma.usermanager.infrastructure.db.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {
	
	private final ProfileDao profileDao;
	
	@Override
	public boolean exist(int profileId) {
		Optional<ProfileMySqlEntity> profileEntity = this.profileDao.findById(profileId);
		return !profileEntity.isEmpty();
	}

}
