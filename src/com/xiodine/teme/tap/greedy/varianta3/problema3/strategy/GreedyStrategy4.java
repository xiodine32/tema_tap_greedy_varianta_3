package com.xiodine.teme.tap.greedy.varianta3.problema3.strategy;


import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.Range;
import com.xiodine.teme.tap.greedy.varianta3.problema3.RangeWithHistory;

import java.util.ArrayList;

/**
 * Using "Spectacle Problem":
 * construct while have elements best Range
 * remove elements from list
 *
 * This strategy is optimal.
 */
public class GreedyStrategy4 implements OneStrategy<ArrayList<Range>, RangeWithHistory> {

    @Override
    public void setElements(ArrayList<Range> ranges) {

    }

    @Override
    public RangeWithHistory select() {
        return null;
    }

    @Override
    public boolean canSelect() {
        return false;
    }

    @Override
    public String toString() {
        return "Greedy Strategy #4";
    }

}
