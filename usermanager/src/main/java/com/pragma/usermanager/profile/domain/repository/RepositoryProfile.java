package com.pragma.usermanager.profile.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.usermanager.profile.domain.entity.ProfileEntity;

@Repository
public interface RepositoryProfile extends CrudRepository<ProfileEntity, Integer> {

}
