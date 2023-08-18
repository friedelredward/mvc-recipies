package com.example.mvcrecipes.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by r.edward on {18/08/2023}
 */
class CategoryTest {
    Category category;

    @BeforeEach
    public void setUp(){
        category= new Category();
    }


    @Test
    void getName() {
        Long longId= 4L;

        category.setId(longId);

        assertEquals(longId, category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipies() {
    }
}