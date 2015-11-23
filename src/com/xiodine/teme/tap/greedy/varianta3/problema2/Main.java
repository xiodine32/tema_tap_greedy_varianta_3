package com.xiodine.teme.tap.greedy.varianta3.problema2;

import com.xiodine.teme.tap.greedy.varianta3.helpers.OneStrategy;
import com.xiodine.teme.tap.greedy.varianta3.problema2.strategy.GreedyStrategy;

import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    OneStrategy<Element, Integer> player;

    public Main() {

        // load strategies
        player = new GreedyStrategy();


        try (Scanner input = new Scanner(System.in)) {

            int n = input.nextInt();

            // prepare
            Element[] elements = new Element[n + 1];
            boolean[] isChild = new boolean[n + 1];

            // load list
            while (input.hasNextInt()) {

                // read
                int a = input.nextInt();
                int b = input.nextInt();

                // init
                if (elements[a] == null)
                    elements[a] = new Element(a);
                if (elements[b] == null)
                    elements[b] = new Element(b);

                // set relations
                elements[a].addElement(elements[b]);
                isChild[b] = true;
            }

            // find root
            Element root = null;
            for (int index = 1; index < isChild.length; index++) {
                if (!isChild[index]) {
                    root = elements[index];
                    break;
                }
            }
            assert root != null;

            root.recursiveUpdateHeight(0);

            // set root
            player.setElements(root);

            // run algorithm
            while (player.canSelect()) {
                System.out.println(player + " selects: " + player.select());
            }
        }
    }
}
