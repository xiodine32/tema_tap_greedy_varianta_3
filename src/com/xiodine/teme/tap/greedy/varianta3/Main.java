package com.xiodine.teme.tap.greedy.varianta3;

import com.xiodine.teme.tap.greedy.varianta3.helpers.Menu;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            // create problem picker
            Menu menuHelper = Menu.factory("Pick exercise number", new String[]{"Problem 1", "Problem 2", "Problem 3", "exit"});

            // pick problem
            menuHelper.run(System.out, new Scanner(System.in));

            // get answer
            int problema = menuHelper.getAnswer();

            if (problema == 3)
                break;

            // construct class
            Class<?> selectedClass = null;
            try {
                selectedClass = Class.forName("com.xiodine.teme.tap.greedy.varianta3.problema" + problema + ".Main");
            } catch (Exception e) {
                System.err.println("Error loading problem!");
            }
            if (selectedClass == null)
                continue;

            Constructor constructor = null;
            try {
                constructor = selectedClass.getConstructor();
            } catch (Exception e) {
                System.err.println("Error getting constructor for the problem!");
            }

            if (constructor == null)
                continue;


            // start loading redirects
            InputStream in = selectedClass.getResourceAsStream("/input.in");

            if (in == null) {
                System.err.print("Input file not found!");
                continue;
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            // save old redirects
            InputStream oldIn = System.in;
            PrintStream oldOut = System.out;


            // redirect
            System.setOut(new PrintStream(out));
            System.setIn(in);

            // prepare timer
            NanoTimer timer = new NanoTimer();
            timer.setLambda(constructor);

            // run test
            try {
                timer.runTest();
            } catch (Exception e) {
                System.err.println("Uh oh, program crashed!");
                e.printStackTrace();
            }

            // get output
            String result = null;
            try {
                result = out.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                System.err.println("Result cannot be encoded to UTF-8.");
            }


            // restore redirects
            System.setOut(oldOut);
            System.setIn(oldIn);


            // write to output
            System.out.println("Result: " + result);
            System.out.printf("Time elapsed: %.5fs\n", timer.getTimerDuration() / 1000000000.0);
            System.out.println();
        }
        System.out.println("Goodbye!");
    }
}
