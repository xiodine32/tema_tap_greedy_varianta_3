package com.xiodine.teme.tap.greedy.varianta3.problema3.strategy;


import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.Range;
import com.xiodine.teme.tap.greedy.varianta3.problema3.RangeWithHistory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Sorts ascending after end.
 * For each I:
 * adds I to an already built Range (if possible)
 * if more than one, pick the one with greatest end
 * otherwise construct new Range
 *
 * This strategy is optimal.
 */
public class GreedyStrategy3 implements OneStrategy<ArrayList<Range>, RangeWithHistory> {
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

        // for each element
        for (Range range : sorted) {

            // get matching range
            Range match = getMatch(range);

            if (match == null)
                this.ranges.add(new RangeWithHistory(range.getStart(), range.getEnd()));
            else
                match.unite(range);

        }
    }

    private Range getMatch(Range range) {
        Range foundRange = null;
        for (Range realRange : this.ranges)
            if (realRange.getEnd() < range.getStart()) {
                if (foundRange == null)
                    foundRange = realRange;

                // if more than one, pick the one with greatest end
                if (foundRange.getEnd() < realRange.getEnd())
                    foundRange = realRange;
            }
        return foundRange;
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
        return "Greedy Strategy #3";
    }
}
