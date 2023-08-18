package com.example.mvcrecipes.controllers;

import com.example.mvcrecipes.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by r.edward on {18/08/2023}
 */
class IndexControllerTest {
    private AutoCloseable closeable;
    IndexController indexController;
    @Mock RecipeService recipeService;
    //*method dependency also needs mock*/
    @Mock Model model;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        indexController= new IndexController(recipeService);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void getIndexPage() {
        String result= indexController.getIndexPage(model);

        assertEquals(result, "index");
        verify(recipeService, times(1)).getRecipes();
        verify(model , times(1)).addAttribute(eq("recipes"), anySet());
    }
}