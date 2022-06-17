package com.pragma.usermanager.person.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.usermanager.person.domain.entity.PersonEntity;

@Repository
public interface RepositoryPerson extends CrudRepository<PersonEntity, Integer> {

}
