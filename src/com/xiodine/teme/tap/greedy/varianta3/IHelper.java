package com.xiodine.teme.tap.greedy.varianta3;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
public interface IHelper {

    boolean queryUser(Scanner scanner);
    void displayQuestion(PrintStream printer);
    int getAnswer();

    default void run(PrintStream printer, Scanner scanner) {
        do {
            displayQuestion(printer);
        } while (!queryUser(scanner));
        printer.println();
    }
}
