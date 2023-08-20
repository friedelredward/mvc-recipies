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
public class IngredientsToIngredientsCommand implements Converter<Ingredient, IngredientCommand> {
    private final UomToUomCommand uomToUomCommandConverter;

    public IngredientsToIngredientsCommand(UomToUomCommand uomToUomCommandConverter) {
        this.uomToUomCommandConverter = uomToUomCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source== null)return null;
        final IngredientCommand command= new IngredientCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setAmount(source.getAmount());
        command.setRecipe(source.getRecipe());
//        command.setUoms(source.getUoms());
        //beware it's a list
        if(source.getUoms() != null && !source.getUoms().isEmpty()){
            source.getUoms().forEach(unitOfMeasure -> {
                command.getUoms().add(uomToUomCommandConverter.convert(unitOfMeasure));
            });
        }
//        command.setUoms(uomToUomCommandConverter.convert(source.getUoms()));
        return command;
    }
}
