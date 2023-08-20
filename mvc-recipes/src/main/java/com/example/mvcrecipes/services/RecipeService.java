package com.example.mvcrecipes.services;

import com.example.mvcrecipes.domain.Recipe;

import java.util.Optional;
import java.util.Set;

/**
 * Created by r.edward on {17/08/2023}
 * dummy class for demo purposes of slf4j annotation form lombock
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
    Optional<Recipe> findById(Long id);
}
