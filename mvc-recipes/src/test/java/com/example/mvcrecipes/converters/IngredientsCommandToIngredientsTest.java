package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.IngredientCommand;
import com.example.mvcrecipes.commands.UnitOfMeasureCommand;
import com.example.mvcrecipes.domain.Ingredient;
import com.example.mvcrecipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class IngredientsCommandToIngredientsTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    public static final BigDecimal AMOUNT= new BigDecimal(LONG_VALUE);
    IngredientsCommandToIngredients converter;

    @BeforeEach
    void setUp() {
        converter= new IngredientsCommandToIngredients(new UomCommandsToUom());
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }
    @Test
    void convert() {
        final Recipe recipe= new Recipe();
        final Set<UnitOfMeasureCommand> uoms= new HashSet<>();
        final IngredientCommand command= new IngredientCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        command.setRecipe(recipe);
        command.setUoms(uoms);

        Ingredient ingredient= converter.convert(command);

        assertNotNull(ingredient);
        assertEquals(LONG_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(recipe, ingredient.getRecipe());
        assertEquals(uoms, ingredient.getUoms());
    }
}