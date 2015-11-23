package com.xiodine.teme.tap.greedy.varianta3.problema3;

/**
 * File created at: 11/22/15 - 9:06 PM
 */
public class Element {
    private int start;
    private int end;

    public Element(int start, int end) {
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
        return end - start;
    }

    @Override
    public String toString() {
        return String.format("[%d - %d]", start, end);
    }
}
