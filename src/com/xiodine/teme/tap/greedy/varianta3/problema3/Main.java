package com.xiodine.teme.tap.greedy.varianta3.problema3;

import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy2;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    ArrayList<OneStrategy<ArrayList<Element>, Integer>> players = new ArrayList<>();

    public Main() {

        // load strategies
        players.add(new GreedyStrategy());
        players.add(new GreedyStrategy2());
        players.add(new GreedyStrategy3());


        try (Scanner input = new Scanner(System.in)) {

            int n = input.nextInt();

            // prepare
            ArrayList<Element> elements = new ArrayList<>();


            // load list
            while (input.hasNextInt()) {

                // read
                int a = input.nextInt();
                int b = input.nextInt();

                elements.add(new Element(a, b));
            }

            for (OneStrategy<ArrayList<Element>, Integer> player : players) {
                // prepare player
                player.setElements(elements);

                // run algorithm
                while (player.canSelect()) {
                    System.out.println(player + " selects: " + player.select());
                }
            }
        }
    }
}
