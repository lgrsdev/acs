package com.lgrsdev.acsexercise.service;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository repository;

    public void postResource(String resourceName, String resourceEntity) {
        repository.save(Resource.builder().key(resourceName).value(resourceEntity).build());
    }

    public String getResourceEntity(String resourceName) {
        Optional<Resource> resource = repository.findById(resourceName);
        return resource.map(Resource::getValue)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, resourceName + " not found"));
    }
}
