package com.lgrsdev.acsexercise.repository;

import com.lgrsdev.acsexercise.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {
}
