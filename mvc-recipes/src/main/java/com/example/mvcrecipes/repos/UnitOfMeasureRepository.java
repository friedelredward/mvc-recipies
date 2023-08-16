package com.example.mvcrecipes.repos;

import com.example.mvcrecipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by r.edward on {16/08/2023}
 */
public interface UnitOfMeasureRepository  extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
