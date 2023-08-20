package com.example.mvcrecipes.commands;

import com.example.mvcrecipes.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {20/08/2023}
 */
@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<CategoryCommand> categories= new HashSet<>();
    private Set<IngredientCommand> ingredients= new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
}
