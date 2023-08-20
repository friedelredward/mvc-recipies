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
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Synchronized//multi thread safe since spriung soenst make it sure here
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if(source== null)return null;
        final CategoryCommand command= new CategoryCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        return command;
    }
}
