package com.tw.assignments.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CellTest {

    @Test
    void shouldReturnTrueWhenCellNeighboursAreSameAsExpected() {
        Cell cell = new Cell(1, 1);
        List<Cell> actualCellNeighbours = cell.getNeighbours();

        List<Cell> expectedNeighbours = new ArrayList<>();
        expectedNeighbours.add(new Cell(0, 0));
        expectedNeighbours.add(new Cell(0, 1));
        expectedNeighbours.add(new Cell(0, 2));
        expectedNeighbours.add(new Cell(1, 0));
        expectedNeighbours.add(new Cell(1, 2));
        expectedNeighbours.add(new Cell(2, 0));
        expectedNeighbours.add(new Cell(2, 1));
        expectedNeighbours.add(new Cell(2, 2));

        assertThat(expectedNeighbours, is(equalTo(actualCellNeighbours)));
    }
}
