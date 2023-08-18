package com.example.mvcrecipes.repos;

import com.example.mvcrecipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by r.edward on {18/08/2023}
 * this method impl was generated so might wanna test it with integration (full)
 * this is integration testing since we wire up the context once and
 *  * also we init the db.
 *  Here is where we could assume and test aall data from data.sql
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired UnitOfMeasureRepository unitOfMeasureRepository;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByDescriptionPinch() {
        //this will b a  real call since we autowire it
        Optional<UnitOfMeasure> foundUom= unitOfMeasureRepository.findByDescription("Pinch");
        assertEquals("Pinch", foundUom.get().getDescription());
    }

    //this would make the context reaload if needed
    // @DirtiesContext
    @Test
    void findByDescriptionCup() {
        //this will b a  real call since we autowire it
        Optional<UnitOfMeasure> foundUom= unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", foundUom.get().getDescription());
    }
}