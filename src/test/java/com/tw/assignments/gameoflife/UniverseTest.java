package com.tw.assignments.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniverseTest {

    @Test
    void shouldReturnTrueIfNextGenerationIsEqualToExpected() {

        List<Cell> currentGeneration = new ArrayList<>();
        currentGeneration.add(new Cell(1,1));
        currentGeneration.add(new Cell(1,2));
        currentGeneration.add(new Cell(2,1));
        currentGeneration.add(new Cell(2,2));
        Universe universe = new Universe(currentGeneration);

        List<Cell> expectedNewGeneration = new ArrayList<>();
//        expectedNewGeneration.add(new Cell(1,1));
//        expectedNewGeneration.add(new Cell(1,2));
//        expectedNewGeneration.add(new Cell(2,1));
//        expectedNewGeneration.add(new Cell(2,2));

        List<Cell> newGeneration = universe.newGeneration();
        assertThat(expectedNewGeneration, is(equalTo(newGeneration)));
    }
}
