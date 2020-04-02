package com.lgrsdev.acsexercise.controller;

import com.lgrsdev.acsexercise.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/{resource}")
    public void postResource(@PathVariable("resource") String resourceName, @RequestBody String resourceEntity) {
        resourceService.postResource(resourceName, resourceEntity);
    }

    @GetMapping("/{resource}")
    public String getResource(@PathVariable("resource") String resourceName) {
        return resourceService.getResourceEntity(resourceName);
    }
}
