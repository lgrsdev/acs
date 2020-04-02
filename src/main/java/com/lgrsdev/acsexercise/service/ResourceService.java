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

    public void postResource(Resource resource) {
        repository.save(resource);
    }

    public Optional<Resource> getResourceEntity(String resourceName) {
        return repository.findById(resourceName);
    }
}
