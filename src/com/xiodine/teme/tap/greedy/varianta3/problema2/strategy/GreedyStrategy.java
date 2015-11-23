package com.xiodine.teme.tap.greedy.varianta3.problema2.strategy;

import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema2.Element;

import java.util.ArrayList;


/**
 * Simple greedy strategy that only works for a tree. If it's not a tree (not convex or has cycles):
 *  a) This strategy won't select the separated groups, but the greedy strategy will still work.
 *  b) it won't know which one to select when a cycle is encountered (and which one to prefer), and thus the greedy
 *      strategy won't work.
 */
public class GreedyStrategy implements OneStrategy<Element, Integer> {

    private ArrayList<Integer> selection = null;

    @Override
    public String toString() {
        return "Greedy Strategy";
    }


    @Override
    public void setElements(Element elements) {
        boolean selectingOdds = shouldSelectOdds(elements);
        selection = prepareSelection(elements, selectingOdds);
    }

    /**
     * Prepares selection of elements
     * @param elements Root element
     * @param selectingOdds Selecting odd height elements
     * @return Array list with all selected nodes.
     */
    private ArrayList<Integer> prepareSelection(Element elements, boolean selectingOdds) {
        ArrayList<Integer> selection = new ArrayList<>();

        elements.recursive(item -> {
            if (item.getHeight() % 2 == 1 && selectingOdds)
                selection.add(item.getNumber());
            if (item.getHeight() % 2 == 0 && !selectingOdds)
                selection.add(item.getNumber());
        });

        return selection;
    }

    /**
     * Chooses between selecting odd or even height elements
     *
     * @param elements Element root
     * @return True if selecting odd height elements
     */
    private boolean shouldSelectOdds(Element elements) {
        long[] count = new long[2];
        elements.recursive(item -> count[item.getHeight() % 2]++);
        return count[0] < count[1];
    }

    @Override
    public Integer select() {
        Integer item = selection.get(0);
        selection.remove(0);
        return item;
    }

    @Override
    public boolean canSelect() {
        return !selection.isEmpty();
    }
}
