package com.example.mvcrecipes.commands;

import com.example.mvcrecipes.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {20/08/2023}
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Recipe recipe;
    private Set<UnitOfMeasureCommand> uoms= new HashSet<>();
}
