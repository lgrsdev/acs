package com.lgrsdev.acsexercise.controller;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private static final Logger log = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    ResourceService resourceService;

    @PostMapping
    public Resource postResource(@RequestBody Resource resource) {
        return resourceService.postResource(resource);
    }

    @GetMapping
    public Resource getResource() {
        return resourceService.getResource();
    }
}
