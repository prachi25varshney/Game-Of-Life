package com.tw.assignments.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    List<Cell> getNeighbours() {
        List<Cell> neighbours = new ArrayList<>();
        int x = this.xCoordinate;
        for (int row = x - 1; row <= x + 1; row++) {
            this.getColumnNeighbours(neighbours, row);
        }
        return neighbours;
    }

    private void getColumnNeighbours(List<Cell> neighbours, int row) {
        int x = this.xCoordinate;
        int y = this.yCoordinate;
        for (int column = y - 1; column <= y + 1; column++) {
            if (row != x || column != y)
                neighbours.add(new Cell(row, column));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate && yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
