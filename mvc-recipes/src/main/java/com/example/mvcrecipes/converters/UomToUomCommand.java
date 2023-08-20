package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.UnitOfMeasureCommand;
import com.example.mvcrecipes.domain.UnitOfMeasure;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class UomToUomCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Synchronized//multi thread safe since spriung soenst make it sure here
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source != null){
            final UnitOfMeasureCommand unitOfMeasureCommand= new UnitOfMeasureCommand();
            unitOfMeasureCommand.setId(source.getId());
            unitOfMeasureCommand.setDescription(source.getDescription());
            return unitOfMeasureCommand;
        }
        return null;
    }
}
