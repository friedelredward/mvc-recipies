package com.example.mvcrecipes.services;

import com.example.mvcrecipes.domain.Recipe;
import com.example.mvcrecipes.repos.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Created by r.edward on {18/08/2023}
 */
class RecipeServiceImplTest {
    private AutoCloseable closeable;
    //we need the service and its dependencies
    RecipeServiceImpl recipeService;
    @Mock RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.initMocks(this);
        closeable = MockitoAnnotations.openMocks(this);
        recipeService= new RecipeServiceImpl(recipeRepository);
    }
/*
    @Before public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }*/

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    void getRecipesEmpty() {
        Set<Recipe> recipes= recipeService.getRecipes();
        assertEquals(recipes.size(), 0);
    }

    @Test
    void getRecipes() {
        Recipe recipe= new Recipe();
        Set<Recipe> recipesData= new HashSet<>();
        recipesData.add(recipe);
        //when
        when(recipeRepository.findAll()).thenReturn(recipesData);
        //if
        Set<Recipe> recipes= recipeService.getRecipes();
        //then
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}