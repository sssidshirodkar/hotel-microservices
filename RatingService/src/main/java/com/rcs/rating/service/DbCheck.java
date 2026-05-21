package com.rcs.rating.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbCheck {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void check() {
        System.out.println("👉 Connected DB: " + mongoTemplate.getDb().getName());
    }
}