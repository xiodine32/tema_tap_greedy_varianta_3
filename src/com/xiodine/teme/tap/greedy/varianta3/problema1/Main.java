package com.xiodine.teme.tap.greedy.varianta3.problema1;

import com.xiodine.teme.tap.greedy.varianta3.problema1.strategy.GreedyStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema1.strategy.RandomStrategy;

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
        boolean gameRunning;
        Boolean oldValue = null;
        while (true) {
            gameRunning = player1.canPlay(list) && player2.canPlay(list);
            if (!gameRunning)
                break;

            oldValue = player1.select(list, oldValue);
            if (!oldValue) list.remove(0);
            else list.remove(list.size() - 1);
            oldValue = player2.select(list, oldValue);
            if (!oldValue) list.remove(0);
            else list.remove(list.size() - 1);

        }
        System.out.println(player1);
        System.out.println(player2);

    }
}
