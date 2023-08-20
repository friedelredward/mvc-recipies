package com.example.mvcrecipes.repos;

import com.example.mvcrecipes.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by r.edward on {20/08/2023}
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
