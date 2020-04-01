package com.lgrsdev.acsexercise.controller;

import com.lgrsdev.acsexercise.model.Resource;
import com.lgrsdev.acsexercise.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/{resource}")
    public void postResource(@PathVariable String resource, @RequestBody String resourceEntity) {
        resourceService.postResource(resource, resourceEntity);
    }

    @GetMapping("/{resource}")
    public Resource getResource(@PathVariable String resource) {
        return resourceService.getResource(resource);
    }
}
