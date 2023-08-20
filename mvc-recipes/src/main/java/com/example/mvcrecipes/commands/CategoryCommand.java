package com.example.mvcrecipes.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by r.edward on {20/08/2023}
 * It's good practice to have separated command objects
 * because since business grows demands tend to differ
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
