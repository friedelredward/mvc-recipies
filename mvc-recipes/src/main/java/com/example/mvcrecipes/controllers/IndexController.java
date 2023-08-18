package com.example.mvcrecipes.controllers;

import com.example.mvcrecipes.repos.CategoryRepository;
import com.example.mvcrecipes.repos.UnitOfMeasureRepository;
import com.example.mvcrecipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {12/08/2023}
 */
@Slf4j
@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository  unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
/*        log.debug("logging from index controller");
        Optional<Category> categoryOptional= categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional= unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("cat id is: " + categoryOptional.get().getId());
        System.out.println("Unit id is: " + uomOptional.get().getId());*/

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
