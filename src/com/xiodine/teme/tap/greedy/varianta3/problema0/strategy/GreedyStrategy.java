package com.xiodine.teme.tap.greedy.varianta3.problema0.strategy;

import java.util.ArrayList;

/**
 * File created at: 11/21/15 - 12:06 PM
 */
public class GreedyStrategy implements IStrategy<ArrayList<Integer>, Boolean> {

    private boolean firstPick = false;
    private boolean chosenOdds = false;


    @Override
    public Boolean select(ArrayList<Integer> oldElements, Boolean competitionPick) {
        return null;
    }

    @Override
    public boolean canSelect(ArrayList<Integer> elements) {
        return !elements.isEmpty();
    }
}
