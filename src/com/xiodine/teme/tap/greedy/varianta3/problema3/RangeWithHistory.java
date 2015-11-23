package com.xiodine.teme.tap.greedy.varianta3.problema3;


import java.util.ArrayList;

/**
 * Range defined as such: [start, end]
 */
public class RangeWithHistory extends Range {

    private ArrayList<Range> ranges;

    public RangeWithHistory(int start, int end) {
        super(start, end);
        ranges = new ArrayList<>();
        ranges.add(new Range(start, end));
    }

    public ArrayList<Range> getRanges() {
        return ranges;
    }

    @Override
    public void unite(Range range) {
        ranges.add(range);
        super.unite(range);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + ranges.toString();
    }
}
