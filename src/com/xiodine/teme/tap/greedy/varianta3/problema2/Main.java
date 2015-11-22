package com.xiodine.teme.tap.greedy.varianta3.problema2;

import com.xiodine.teme.tap.greedy.varianta3.problema2.strategy.GreedyStrategy;

import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    GreedyStrategy player;

    public Main() {

        // load strategies
        player = new GreedyStrategy();


        try (Scanner input = new Scanner(System.in)) {

            int n = input.nextInt();

            // prepare
            Element parent = null;
            int[] freq = new int[n + 1];
            int[] sons = new int[n + 1];

            // load list
            while (input.hasNextLine()) {
                int a = input.nextInt();
                int b = input.nextInt();
                //TODO: implement constructing parent element
            }
        }

    }
}
