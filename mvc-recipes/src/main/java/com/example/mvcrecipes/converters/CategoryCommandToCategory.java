package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.CategoryCommand;
import com.example.mvcrecipes.domain.Category;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source== null) return null;
        final Category category= new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return  category;
    }
}
