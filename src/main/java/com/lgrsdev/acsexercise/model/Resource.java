package com.lgrsdev.acsexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash @Builder
public class Resource {

    @Id
    @JsonProperty("resource")
    private String key;

    @JsonProperty("resourceEntity")
    private String value;
}
