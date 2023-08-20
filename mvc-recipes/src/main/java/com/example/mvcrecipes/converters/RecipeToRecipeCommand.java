package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.RecipeCommand;
import com.example.mvcrecipes.domain.Category;
import com.example.mvcrecipes.domain.Recipe;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final NotesToNotesCommand notesCommand;
    private final CategoryToCategoryCommand categoryCommand;
    private final IngredientsToIngredientsCommand ingredientsCommand;

    public RecipeToRecipeCommand(NotesToNotesCommand notesCommand, CategoryToCategoryCommand categoryCommand, IngredientsToIngredientsCommand ingredientsCommand) {
        this.notesCommand = notesCommand;
        this.categoryCommand = categoryCommand;
        this.ingredientsCommand = ingredientsCommand;
    }

    @Nullable
    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source== null) return null;
        final RecipeCommand command= new RecipeCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setImage(source.getImage());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setServings(source.getServings());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());

//        command.setCategories(source.getCategories());
        command.setNotes(notesCommand.convert(source.getNotes()));

        if (source.getCategories() != null && !source.getCategories().isEmpty()){
            source.getCategories()
                    .forEach((Category category) -> command.getCategories().add(categoryCommand.convert(category)));
        }

        if (source.getIngredients() != null && !source.getIngredients().isEmpty()){
            source.getIngredients()
                    .forEach(ingredient -> command.getIngredients().add(ingredientsCommand.convert(ingredient)));
        }
        return command;
    }
}
