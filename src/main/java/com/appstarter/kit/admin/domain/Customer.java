package com.appstarter.kit.admin.domain;

import lombok.Data;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.util.UUID;

@Data
public class Customer {
    @PrimaryKey
    private UUID id;
    private String name;
    private int age;
    private boolean active;
}
