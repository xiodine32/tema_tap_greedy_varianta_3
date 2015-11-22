package com.xiodine.teme.tap.greedy.varianta3.problema1;

import com.xiodine.teme.tap.greedy.varianta3.helpers.TwoStrategy;

import java.util.ArrayList;

/**
 * File created at: 11/21/15 - 12:59 PM
 */
public class Player {
    private TwoStrategy<Integer, ArrayList<Integer>, Boolean> playerStrategy;
    private ArrayList<Integer> selectedElements;
    private long selectedSum = 0;

    public Player(TwoStrategy<Integer, ArrayList<Integer>, Boolean> playerStrategy) {
        this.selectedElements = new ArrayList<>();
        this.playerStrategy = playerStrategy;
    }

    Boolean select(ArrayList<Integer> oldElements, Boolean competitionPick) {
        Boolean result = playerStrategy.select(oldElements, competitionPick);
        addResult(oldElements, result);

        return result;
    }

    private void addResult(ArrayList<Integer> oldElements, Boolean result) {

        // check for errors
        if (result == null)
            throw new NullPointerException("Result cannot be null!");

        int selectedElement;


        // verify item selected (left == false)
        if (!result) selectedElement = oldElements.get(0);
        else selectedElement = oldElements.get(oldElements.size() - 1);

        selectedElements.add(selectedElement);
        selectedSum += selectedElement;

    }

    public boolean canPlay(ArrayList<Integer> list) {
        return playerStrategy.canSelect(list);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Player with strategy: ");
        builder.append(playerStrategy.toString());

        builder.append("\nselected elements: ");
        for (int item : selectedElements) {
            builder.append(item);
            builder.append(" ");
        }

        builder.append("\nselected sum: ");
        builder.append(selectedSum);

        return builder.toString();
    }
}
