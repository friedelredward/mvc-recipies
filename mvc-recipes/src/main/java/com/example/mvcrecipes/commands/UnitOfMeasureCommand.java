package com.example.mvcrecipes.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by r.edward on {20/08/2023}
 */
@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private IngredientCommand ingredient;
    private String description;
}
