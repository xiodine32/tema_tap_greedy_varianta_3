package com.xiodine.teme.tap.greedy.varianta3.problema3.strategy;


import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.Element;

import java.util.ArrayList;

// TODO: implement greedy strategy
public class GreedyStrategy3 implements OneStrategy<ArrayList<Element>, Integer> {

    @Override
    public void setElements(ArrayList<Element> elements) {

    }

    @Override
    public Integer select() {
        return null;
    }

    @Override
    public boolean canSelect() {
        return false;
    }

    @Override
    public String toString() {
        return "Greedy Strategy #3";
    }

}
