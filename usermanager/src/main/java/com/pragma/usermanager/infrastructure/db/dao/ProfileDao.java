package com.pragma.usermanager.infrastructure.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.infrastructure.db.entity.ProfileMySqlEntity;

public interface ProfileDao extends CrudRepository<ProfileMySqlEntity, Integer> {

}
