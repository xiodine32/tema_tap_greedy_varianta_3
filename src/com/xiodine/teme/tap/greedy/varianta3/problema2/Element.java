package com.xiodine.teme.tap.greedy.varianta3.problema2;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * File created at: 11/22/15 - 9:06 PM
 */
public class Element {
    ArrayList<Element> descendants;
    int number;
    int height;

    public Element(int number) {
        this.number = number;
        this.height = 0;
        this.descendants = new ArrayList<>();
    }

    public Element add(int number) {
        Element element = new Element(number);
        element.height = this.height + 1;
        descendants.add(element);
        return element;
    }

    public ArrayList<Element> getDescendants() {
        return descendants;
    }

    public int getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    public void recursive(Consumer<Element> consumer) {
        descendants.forEach(consumer::accept);
        for (Element element : descendants) {
            element.recursive(consumer);
        }
    }
}
