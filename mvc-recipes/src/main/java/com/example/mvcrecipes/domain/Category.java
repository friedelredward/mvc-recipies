package com.example.mvcrecipes.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Created by r.edward on {16/08/2023}
 * ojo EAch Many2Many creates a new table
 * so we have to configure ir properly
 */
@Data
@EqualsAndHashCode(exclude = {"recipies"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipies;

}
