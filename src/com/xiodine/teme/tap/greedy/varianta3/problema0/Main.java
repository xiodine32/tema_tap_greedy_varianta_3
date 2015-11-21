package com.xiodine.teme.tap.greedy.varianta3.problema0;

import com.xiodine.teme.tap.greedy.varianta3.problema0.strategy.GreedyStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema0.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    Player player1;
    Player player2;

    public Main() {

        // load strategies
        player1 = new Player(new GreedyStrategy());
        player2 = new Player(new RandomStrategy());


        // load list
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextInt()) {
                list.add(input.nextInt());
            }
        }

        // run test
        boolean gameRunning = true;
        while (gameRunning) {

            gameRunning = player1.canPlay(list) && player2.canPlay(list);
        }
    }
}
