package com.pragma.usermanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.usermanager.model.entity.ProfileEntity;

@Repository
public interface RepositoryProfile extends CrudRepository<ProfileEntity, Integer> {

}