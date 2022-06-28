package com.pragma.usermanager.infrastructure.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.infrastructure.db.entity.PersonMySqlEntity;

public interface PersonDao extends CrudRepository<PersonMySqlEntity, Integer> {

}
