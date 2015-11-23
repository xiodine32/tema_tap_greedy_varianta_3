package com.xiodine.teme.tap.greedy.varianta3.problema3.strategy;


import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.Range;
import com.xiodine.teme.tap.greedy.varianta3.problema3.RangeWithHistory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Using "Spectacle Problem":
 * construct while have elements best Range
 * remove elements from list
 *
 * This strategy is not optimal, suffers the same fate as Greedy Strategy #2.
 * It would be better to implement picking the one with greatest end.
 * See counter example in input.in
 */
public class GreedyStrategy4 implements OneStrategy<ArrayList<Range>, RangeWithHistory> {
    private ArrayList<Range> sorted = null;
    private ArrayList<RangeWithHistory> ranges = null;

    public void setElements(ArrayList<Range> ranges) {

        sorted = new ArrayList<>(ranges);
        this.ranges = new ArrayList<>();

        runGreedy();

    }

    private void runGreedy() {

        // sort
        Collections.sort(sorted, (a, b) -> a.getEnd() - b.getEnd());


        while (!sorted.isEmpty()) {


            RangeWithHistory partition = null;

            for (Range realRange : this.sorted) {
                if (partition == null) {
                    partition = new RangeWithHistory(realRange.getStart(), realRange.getEnd());
                    continue;
                }

                if (realRange.getStart() >= partition.getEnd()) {
                    partition.unite(realRange);
                }
            }

            if (partition != null) {
                sorted.removeAll(partition.getRanges());
                System.out.println(partition);
            }
        }
    }

    @Override
    public RangeWithHistory select() {
        RangeWithHistory rangeWithHistory = this.ranges.get(0);
        this.ranges.remove(0);
        return rangeWithHistory;
    }

    @Override
    public boolean canSelect() {
        return !this.ranges.isEmpty();
    }

    @Override
    public String toString() {
        return "Greedy Strategy #4";
    }
}
