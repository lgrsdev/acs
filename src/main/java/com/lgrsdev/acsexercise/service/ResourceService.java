package com.lgrsdev.acsexercise.service;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository repository;

    public void postResource(String resource, String resourceEntity) {
        repository.save(Resource.builder().key(resource).value(resourceEntity).build());
    }

    public Resource getResource(String resource) {
        return repository.findById(resource).orElse(null);
    }
}
