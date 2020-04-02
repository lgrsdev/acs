package com.lgrsdev.acsexercise.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash @Builder
public class Resource {

    @Id
    private String key;

    @Getter
    private String value;
}
