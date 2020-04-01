package com.lgrsdev.acsexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash @Builder
public class Resource {

    @Id
    private Long id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;
}
