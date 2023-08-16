package com.example.mvcrecipes.repos;
import com.example.mvcrecipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by r.edward on {16/08/2023}
 */
public interface CategoryRepository  extends CrudRepository<Category, Long> {
    /** Optional introduced in Spring4-> Spring5*/
    Optional<Category> findByDescription(String description);
}
