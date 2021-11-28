package com.tw.assignments.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            int aliveNeighbours = cellNeighbour.stream().filter(currentGeneration::contains).collect(Collectors.toList()).size();
            if (aliveNeighbours == 3 && !newGeneration.contains(neighbour))
                newGeneration.add(neighbour);
        }
    }

    private void removeDeadCellsFromNewGeneration(List<Cell> newGeneration, Cell cell) {
        int aliveNeighbours = 0;
        List<Cell> neighbours = cell.getNeighbours();
        aliveNeighbours = neighbours.stream().filter(currentGeneration::contains).collect(Collectors.toList()).size();
        if (aliveNeighbours < 2 || aliveNeighbours > 3)
            newGeneration.remove(cell);
    }
}
