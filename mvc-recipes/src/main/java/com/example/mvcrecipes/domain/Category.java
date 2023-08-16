package com.example.mvcrecipes.domain;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Created by r.edward on {16/08/2023}
 * ojo EAch Many2Many creates a new table
 * so we have to configure ir properly
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(Set<Recipe> recipies) {
        this.recipies = recipies;
    }
}
