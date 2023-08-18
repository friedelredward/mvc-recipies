package com.example.mvcrecipes.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by r.edward on {16/08/2023}
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@ToString(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* here leave it as is (DOES NOT DELETE RECIPE ON DELETE)*/
    @OneToOne
    private Recipe recipe;
    /**
     * so this string doesnt limit to 255 in the DB w allow much more.
     */
    @Lob
    private String recipeNotes;

    public Notes() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
