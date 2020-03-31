package com.lgrsdev.acsexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Resource {

    @Id
    private long id = 1;

    @Getter
    @JsonProperty("something")
    private String something;
}
