package com.pragma.usermanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.usermanager.model.entity.CityEntity;

@Repository
public interface RepositoryCity extends CrudRepository<CityEntity, Integer> {

}
