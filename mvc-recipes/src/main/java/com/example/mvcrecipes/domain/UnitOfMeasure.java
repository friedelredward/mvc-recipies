package com.example.mvcrecipes.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by r.edward on {16/08/2023}
 * We create this so a table gets created!!
 *  that means that uom can be anything in the
 *  future
 *  @Note:it's not hardcoded like an ENUM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Ingredient ingredient;
    private String description;
}
