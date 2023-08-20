package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.CategoryCommand;
import com.example.mvcrecipes.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class CategoryToCategoryCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    CategoryToCategoryCommand converter;

    @BeforeEach
    void setUp() {
        converter= new CategoryToCategoryCommand();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    void convert() {
        //given
        Category cat = new Category();
        cat.setId(LONG_VALUE);
        cat.setDescription(DESCRIPTION);

        //when
        CategoryCommand command = converter.convert(cat);

        //then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}