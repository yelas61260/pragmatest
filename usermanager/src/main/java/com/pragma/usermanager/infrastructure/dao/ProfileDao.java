package com.pragma.usermanager.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.domain.entity.ProfileEntity;

public interface ProfileDao extends CrudRepository<ProfileEntity, Integer> {

}
