package com.xiodine.teme.tap.greedy.varianta3.problema0.strategy;

import com.xiodine.teme.tap.greedy.varianta3.helpers.TwoStrategy;

import java.util.ArrayList;

/**
 * File created at: 11/21/15 - 12:06 PM
 */
public class GreedyStrategy implements TwoStrategy<Integer, ArrayList<Integer>, Boolean> {

    private boolean firstPick = false;
    private Boolean lastSelect = null;


    @Override
    public Boolean select(ArrayList<Integer> oldElements, Boolean competitionPick) {
        if (!firstPick)
            lastSelect = firstSelect(oldElements);
        else
            lastSelect = competitionPick;
        return lastSelect;
    }

    /**
     * @param oldElements Old Elements
     * @return If selecting from right of array.
     */
    private boolean firstSelect(ArrayList<Integer> oldElements) {

        // it's the first select
        firstPick = true;

        long[] sums = new long[2];

        for (int i = 0; i < oldElements.size(); i++) {
            sums[i % 2] += oldElements.get(i);
        }
        return sums[0] < sums[1];
    }


    @Override
    public boolean canSelect(ArrayList<Integer> elements) {
        return !elements.isEmpty();
    }

    @Override
    public Boolean getLastSelected() {
        return lastSelect;
    }

    @Override
    public String toString() {
        return "Greedy Strategy";
    }
}
