package com.example.mvcrecipes.converters;

import com.example.mvcrecipes.commands.NotesCommand;
import com.example.mvcrecipes.domain.Notes;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {20/08/2023}
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Nullable
    @Synchronized
    @Override
    public NotesCommand convert(Notes source) {
       if(source== null) return null;
       final NotesCommand command= new NotesCommand();
       command.setId(source.getId());
       command.setRecipeNotes(source.getRecipeNotes());
       return command;
    }
}
