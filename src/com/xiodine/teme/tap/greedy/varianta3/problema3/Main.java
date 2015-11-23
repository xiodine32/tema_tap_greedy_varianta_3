package com.xiodine.teme.tap.greedy.varianta3.problema3;

import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy1;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy2;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy3;
import com.xiodine.teme.tap.greedy.varianta3.problema3.strategy.GreedyStrategy4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    ArrayList<OneStrategy<ArrayList<Range>, RangeWithHistory>> players = new ArrayList<>();

    public Main() {

        // load strategies
        players.add(new GreedyStrategy1());
        players.add(new GreedyStrategy2());
        players.add(new GreedyStrategy3());
        players.add(new GreedyStrategy4());


        try (Scanner input = new Scanner(System.in)) {

            int n = input.nextInt();

            // prepare
            ArrayList<Range> ranges = new ArrayList<>();


            // load list
            while (input.hasNextInt()) {

                // read
                int a = input.nextInt();
                int b = input.nextInt();

                // add range
                ranges.add(new Range(a, b));
            }

            System.out.println("Beginning with: " + ranges + "\n");

            for (OneStrategy<ArrayList<Range>, RangeWithHistory> player : players) {

                System.out.println("Running " + player + ":\n");

                // prepare player
                player.setElements(ranges);

                // run algorithm
                while (player.canSelect()) {
                    System.out.println(player.select());
                }


                System.out.println();
            }
        }
    }
}
