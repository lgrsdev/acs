package com.lgrsdev.acsexercise.service;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository repository;

    public void postResource(String resourceName, String resourceEntity) {
        repository.save(Resource.builder().key(resourceName).value(resourceEntity).build());
    }

    public Optional<Resource> getResource(String resourceName) {
        return repository.findById(resourceName);
    }
}
