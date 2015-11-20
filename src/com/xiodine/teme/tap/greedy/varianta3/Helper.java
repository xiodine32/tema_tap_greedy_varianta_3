package com.xiodine.teme.tap.greedy.varianta3;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
public class Helper implements IHelper {
    private String name;
    private String[] names;
    private int lastSelect;

    public Helper(String name, String[] strings) {
        this.name = name;
        this.names = strings;
    }

    public static IHelper factory(String name, String[] strings) {
        return new Helper(name, strings);
    }


    @Override
    public boolean queryUser(Scanner scanner) {
        if (!scanner.hasNextInt())
            return false;

        lastSelect = scanner.nextInt();
        return true;
    }

    @Override
    public void displayQuestion(PrintStream printer) {
        printer.print(name + ":\n");
        printer.flush();
        int vi = 0;
        for (String i : names) {
            printer.print("  " + (vi++) + ". " + i + "\n");
        }
        printer.print("\nSelect: ");
    }

    @Override
    public int getAnswer() {
        return lastSelect;
    }
}
