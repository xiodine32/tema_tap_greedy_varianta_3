package com.xiodine.teme.tap.greedy.varianta3.problema0.strategy;

import java.util.ArrayList;
import java.util.Random;

/**
 * File created at: 11/21/15 - 12:02 PM
 */
public class RandomStrategy implements IStrategy<ArrayList<Integer>, Boolean> {

    private final Random random = new Random();

    @Override
    public Boolean select(ArrayList<Integer> oldElements, Boolean competitionPick) {
        return random.nextInt(2) == 1;
    }

    @Override
    public boolean canSelect(ArrayList<Integer> elements) {
        return !elements.isEmpty();
    }
}
