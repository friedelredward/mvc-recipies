package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.NotesCommand;
import com.example.mvcrecipes.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class NotesCommandToNotesTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter= new NotesCommandToNotes();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        final NotesCommand command= new NotesCommand();
        command.setId(LONG_VALUE);
        command.setRecipeNotes(DESCRIPTION);

        Notes notes= converter.convert(command);

        assertNotNull(notes);
        assertEquals(LONG_VALUE, notes.getId());
        assertEquals(DESCRIPTION, notes.getRecipeNotes());
    }
}