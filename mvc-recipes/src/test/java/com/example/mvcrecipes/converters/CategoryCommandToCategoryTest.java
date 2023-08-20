package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.CategoryCommand;
import com.example.mvcrecipes.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class CategoryCommandToCategoryTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter= new CategoryCommandToCategory();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert(){
        CategoryCommand command= new CategoryCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        Category cat= converter.convert(command);

        assertNotNull(cat);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());

    }
}