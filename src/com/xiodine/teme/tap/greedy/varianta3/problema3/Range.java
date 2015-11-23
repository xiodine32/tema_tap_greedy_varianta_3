package com.xiodine.teme.tap.greedy.varianta3.problema3;

/**
 * Range defined as such: [start, end]
 */
public class Range {

    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDuration() {
        return end - start + 1;
    }

    @Override
    public String toString() {
        return String.format("%d - %d", start, end);
    }

    public void unite(Range range) {
        start = range.start > start ? start : range.start;
        end = range.end < end ? end : range.end;
    }
}
