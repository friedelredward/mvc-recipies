package com.example.mvcrecipes.repos;

import com.example.mvcrecipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by r.edward on {16/08/2023}
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
