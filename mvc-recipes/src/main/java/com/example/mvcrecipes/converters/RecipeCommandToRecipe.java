package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.RecipeCommand;
import com.example.mvcrecipes.domain.Recipe;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final NotesCommandToNotes notesConverter;
    private final CategoryCommandToCategory toCategory;
    private final IngredientsCommandToIngredients toIngredients;

    public RecipeCommandToRecipe(NotesCommandToNotes notesConverter, CategoryCommandToCategory toCategory, IngredientsCommandToIngredients toIngredients) {
        this.notesConverter = notesConverter;
        this.toCategory = toCategory;
        this.toIngredients = toIngredients;
    }

    @Nullable
    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source== null) return null;
        final Recipe recipe= new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setImage(source.getImage());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());

        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && !source.getCategories().isEmpty()){
            source.getCategories()
                    .forEach( category -> recipe.getCategories().add(toCategory.convert(category)));
        }

        if (source.getIngredients() != null && !source.getIngredients().isEmpty()){
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(toIngredients.convert(ingredient)));
        }

        return recipe;
    }
}
