package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.UnitOfMeasureCommand;
import com.example.mvcrecipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class UomCommandsToUomTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    UomCommandsToUom converter;

    @BeforeEach
    void setUp() {
        converter = new UomCommandsToUom();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}