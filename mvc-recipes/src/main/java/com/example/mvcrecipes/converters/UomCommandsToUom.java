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
public class UomCommandsToUom implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Synchronized//multi thread safe since spriung soenst make it sure here
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source== null) return null;

        final UnitOfMeasure uom= new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());

        return uom;
    }

    @Override
    public <U> Converter<UnitOfMeasureCommand, U> andThen(Converter<? super UnitOfMeasure, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
