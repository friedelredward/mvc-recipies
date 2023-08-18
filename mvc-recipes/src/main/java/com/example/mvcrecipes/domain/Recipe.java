package com.example.mvcrecipes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {16/08/2023}
 * very important set this as entity
 */
@Data
@ToString(exclude = {"notes", "ingredients", "categories"})
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name= "recipe_id"),
        inverseJoinColumns = @JoinColumn(name= "category_id")
    )
    private Set<Category> categories= new HashSet<>();
    /** And we make the recipe the owning side so we:
     * can delete any ingredient without recipe, but not the other way.*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
//    @EqualsAndHashCode.Exclude
    private Set<Ingredient> ingredients= new HashSet<>();
    //todo add
//    private Difficulty difficulty;
    /** this creates a blob field in the db
     * to store larger objs(LargeOBject)*/
    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    /** this make this 1 the owner===
     * WILL delete aLL notes if we delete 1 of this!!! Very Important!! */
    @OneToOne(cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
    private Notes notes;

    /** Since we have some custom made getters and setters
     * we refactor this manually!!! be very careful!! */
    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }
}
