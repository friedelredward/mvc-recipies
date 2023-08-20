package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.IngredientCommand;
import com.example.mvcrecipes.domain.Ingredient;
import com.example.mvcrecipes.domain.Recipe;
import com.example.mvcrecipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class IngredientsToIngredientsCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    public static final BigDecimal AMOUNT= new BigDecimal(LONG_VALUE);
    IngredientsToIngredientsCommand converter;

    @BeforeEach
    void setUp() {
        converter= new IngredientsToIngredientsCommand(new UomToUomCommand());
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }
    @Test
    void convert() {
        final Recipe recipe= new Recipe();
        final Set<UnitOfMeasure> uoms= new HashSet<>();
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(LONG_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setRecipe(recipe);
        ingredient.setUoms(uoms);

        IngredientCommand command1 = converter.convert(ingredient);

        assertNotNull(command1);
        assertEquals(LONG_VALUE, command1.getId());
        assertEquals(DESCRIPTION, command1.getDescription());
        assertEquals(AMOUNT, command1.getAmount());
        assertEquals(recipe, command1.getRecipe());
        assertEquals(uoms, command1.getUoms());
    }
}