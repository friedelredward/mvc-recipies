package com.example.mvcrecipes.controllers;

import com.example.mvcrecipes.domain.Category;
import com.example.mvcrecipes.domain.UnitOfMeasure;
import com.example.mvcrecipes.repos.CategoryRepository;
import com.example.mvcrecipes.repos.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by r.edward on {12/08/2023}
 */
@Slf4j
@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository  unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        log.debug("logging from index controller");
        Optional<Category> categoryOptional= categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional= unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("cat id is: " + categoryOptional.get().getId());
        System.out.println("Unit id is: " + uomOptional.get().getId());
        return "index";
    }
}
