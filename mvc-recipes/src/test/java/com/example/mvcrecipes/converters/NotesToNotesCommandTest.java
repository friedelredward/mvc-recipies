package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.NotesCommand;
import com.example.mvcrecipes.domain.Notes;
import com.example.mvcrecipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {20/08/2023}
 */
class NotesToNotesCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    NotesToNotesCommand converter;

    @BeforeEach
    void setUp() {
        converter= new NotesToNotesCommand();
    }

    @Test
    public void convertNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        final Recipe recipe= new Recipe();
        final Notes notes= new Notes();
        notes.setId(LONG_VALUE);
        notes.setRecipeNotes(DESCRIPTION);
        notes.setRecipe(recipe);

        NotesCommand command= converter.convert(notes);

        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getRecipeNotes());
    }
}