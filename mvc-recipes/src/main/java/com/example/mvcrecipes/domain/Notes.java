package com.example.mvcrecipes.domain;

import jakarta.persistence.*;

/**
 * Created by r.edward on {16/08/2023}
 */
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* here leave it as is (DOES NOT DELETE RECIPE ON DELETE)*/
    @OneToOne
    private Recipe recipe;
    /** so this string doesnt limit to 255 in the DB w allow much more.*/
    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
