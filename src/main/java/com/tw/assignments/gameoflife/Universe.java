package com.tw.assignments.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private final List<Cell> currentGeneration;

    public Universe(List<Cell> currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    List<Cell> newGeneration() {
        List<Cell> newGeneration = new ArrayList<>(currentGeneration);
        for (Cell cell : currentGeneration) {
            this.removeDeadCellsFromNewGeneration(newGeneration, cell);
        }
        for (Cell cell : currentGeneration) {
            this.addNewAliveDeadCellInNewGeneration(newGeneration, cell);
        }

        return newGeneration;
    }

    private void addNewAliveDeadCellInNewGeneration(List<Cell> newGeneration, Cell cell) {

        List<Cell> neighbours = cell.getNeighbours();
        for (Cell neighbour : neighbours) {
            List<Cell> cellNeighbour = neighbour.getNeighbours();
            int liveNeighbours = 0;
            for (Cell alive : cellNeighbour) {
                if (currentGeneration.contains(alive))
                    liveNeighbours++;
            }
            if (liveNeighbours == 3 && !newGeneration.contains(neighbour))
                newGeneration.add(neighbour);
        }
    }

    private void removeDeadCellsFromNewGeneration(List<Cell> newGeneration, Cell cell) {
        int liveNeighbours = 0;
        List<Cell> neighbours = cell.getNeighbours();
        for (Cell neighbour : neighbours) {
            if (currentGeneration.contains(neighbour))
                liveNeighbours++;
        }
        if (liveNeighbours < 2 || liveNeighbours > 3)
            newGeneration.remove(cell);
    }
}
