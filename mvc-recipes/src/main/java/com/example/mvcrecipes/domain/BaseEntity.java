package com.example.mvcrecipes.domain;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Created by r.edward on {17/08/2023}
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
