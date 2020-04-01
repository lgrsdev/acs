package com.lgrsdev.acsexercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.repository.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@Service
public class ResourceService implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ResourceService.class);

    public static final long RESOURCE_ID = 1L;

    @Autowired
    ResourceRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    public void postResource(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
        jsonNode.fields().forEachRemaining(entry -> repository.save(buildResource(entry)));
    }

    public Resource getResource() {
        Optional<Resource> resource = repository.findById(RESOURCE_ID);
        return resource.orElse(null);
    }

    private Resource buildResource(Map.Entry<String, JsonNode> entry) {
        return Resource.builder().id(RESOURCE_ID).key(entry.getKey()).value(entry.getValue().textValue()).build();
    }
}
