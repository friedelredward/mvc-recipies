package com.example.mvcrecipes.controllers;

import com.example.mvcrecipes.domain.Recipe;
import com.example.mvcrecipes.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by r.edward on {18/08/2023}
 */
@ExtendWith(SpringExtension.class)
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

    @Test
    void getIndexPageWithRecipes() {
        //given
        Recipe recipe= new Recipe();
        Recipe recipe2= new Recipe();
        recipe2.setId(1L);//since its the same oibject gets updated in the set but not 2 objects!!
        //so 1 must be different
        Set<Recipe> recipesData= new HashSet<>();
        recipesData.add(recipe);
        recipesData.add(recipe2);
        when(recipeService.getRecipes()).thenReturn(recipesData);
        ArgumentCaptor<Set<Recipe>> setArgumentCaptor= forClass(Set.class);
        //when
        String result= indexController.getIndexPage(model);
        // then
        assertEquals(result, "index");
        verify(recipeService, times(1)).getRecipes();
//        verify(model , times(1)).addAttribute(eq("recipes"), eq(recipesData));
        verify(model , times(1)).addAttribute(eq("recipes"), setArgumentCaptor.capture());
        Set<Recipe> setIncontroller= setArgumentCaptor.getValue();
        assertEquals(2, setIncontroller.size());
    }

    //still a unit test for MVC!!!!!
    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}