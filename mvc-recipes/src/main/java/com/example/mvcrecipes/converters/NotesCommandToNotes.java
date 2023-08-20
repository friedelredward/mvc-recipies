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
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Nullable
    @Synchronized
    @Override
    public Notes convert(NotesCommand source) {
       if(source== null) return null;
       final Notes notes= new Notes();
       notes.setId(source.getId());
       notes.setRecipeNotes(source.getRecipeNotes());
       return notes;
    }
}
