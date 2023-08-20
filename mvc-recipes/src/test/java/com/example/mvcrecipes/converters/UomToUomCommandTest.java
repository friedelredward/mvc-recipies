package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.UnitOfMeasureCommand;
import com.example.mvcrecipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class UomToUomCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    UomToUomCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UomToUomCommand();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand command = converter.convert(uom);

        //then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}