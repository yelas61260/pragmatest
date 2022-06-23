package com.pragma.usermanager.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.domain.entity.PersonEntity;

public interface PersonDao extends CrudRepository<PersonEntity, Integer> {

}
