package com.xiodine.teme.tap.greedy.varianta3.problema1.strategy;

import com.xiodine.teme.tap.greedy.varianta3.helpers.TwoStrategy;

import java.util.ArrayList;
import java.util.Random;

/**
 * File created at: 11/21/15 - 12:02 PM
 */
public class RandomStrategy implements TwoStrategy<Integer, ArrayList<Integer>, Boolean> {

    private final Random random = new Random();
    private Boolean lastSelect = null;

    @Override
    public Boolean select(ArrayList<Integer> oldElements, Boolean competitionPick) {
        lastSelect = random.nextInt(2) == 1;
        return lastSelect;
    }

    @Override
    public boolean canSelect(ArrayList<Integer> elements) {
        return !elements.isEmpty();
    }

    @Override
    public String toString() {
        return "Random Strategy";
    }
}
