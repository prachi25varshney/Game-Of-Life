package com.tw.assignments.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private List<Cell> currentGeneration;

    public Universe(List<Cell> currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    List<Cell> newGeneration() {
        List<Cell> newGeneration = new ArrayList<>();

        return newGeneration;
    }
}
