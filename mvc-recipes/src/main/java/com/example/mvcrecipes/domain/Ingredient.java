package com.example.mvcrecipes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {16/08/2023}
 */
@Data
@EqualsAndHashCode(exclude = {"recipe", "uoms"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private Set<UnitOfMeasure> uoms= new HashSet<>();

    public Ingredient() {
    }
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        addUom(uom);
    }
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        addUom(uom);
        this.recipe = recipe;
    }

    public void addUom(UnitOfMeasure uom){
        uom.setIngredient(this);
        uoms.add(uom);
    }

    public void removeUom(UnitOfMeasure uom){
        uom.setIngredient(null);
        uoms.remove(uom);
    }
}
