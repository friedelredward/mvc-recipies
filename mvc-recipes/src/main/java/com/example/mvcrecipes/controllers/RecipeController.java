package com.example.mvcrecipes.controllers;

import com.example.mvcrecipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {19/08/2023}
 */
@Slf4j
@Controller()
@RequestMapping("/recipe")
public class RecipeController {
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{recipeId}")
    public String findById(Model model, @PathVariable Long recipeId){
        model.addAttribute("recipe", recipeService.findById(recipeId).get());
        return "recipe/show";
    }
}
