package com.lgrsdev.acsexercise.service;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.repository.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class ResourceService implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    ResourceRepository repository;

    public Resource postResource(Resource resource) {
        return repository.save(resource);
    }

    public Resource getResource() {
        Optional<Resource> resource = repository.findById(1L);
        return resource.orElse(null);
    }
}
