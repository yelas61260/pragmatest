package com.pragma.usermanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.usermanager.model.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

}
