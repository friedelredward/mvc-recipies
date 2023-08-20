package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.IngredientCommand;
import com.example.mvcrecipes.domain.Ingredient;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class IngredientsCommandToIngredients implements Converter<IngredientCommand, Ingredient> {
    private final UomCommandsToUom uomCommandsToUomConverter;

    public IngredientsCommandToIngredients(UomCommandsToUom uomCommandsToUomConverter) {
        this.uomCommandsToUomConverter = uomCommandsToUomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source== null)return null;
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setRecipe(source.getRecipe());
//        ingredient.setUoms(source.getUoms());
        if(source.getUoms() != null && !source.getUoms().isEmpty()){
            source.getUoms().forEach(command -> {
                ingredient.getUoms().add(uomCommandsToUomConverter.convert(command));
            });
        }

        return ingredient;
    }
}
