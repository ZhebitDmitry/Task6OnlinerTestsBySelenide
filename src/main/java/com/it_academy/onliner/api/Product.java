package com.it_academy.onliner.api;

public class Product {
    private Integer id;
    private String key;
    private String name;
    private String full_name;

    public Product(Integer id, String key, String name, String full_name) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.full_name = full_name;
    }

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }
}
