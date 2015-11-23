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

    public int getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Updates heights
     *
     * @param height The starting height
     */
    public void recursiveUpdateHeight(int height) {
        this.height = height;
        for (Element descendant : descendants)
            descendant.recursiveUpdateHeight(height + 1);
    }

    /**
     * Applies a function recursively to itself and all it's descendants
     * @param consumer Consumer function that gets called the node and all of it's descendants
     */
    public void recursive(Consumer<Element> consumer) {
        descendants.forEach(consumer::accept);
        for (Element element : descendants) {
            element.recursive(consumer);
        }
    }

    /**
     * Add an element as it's descendant
     *
     * @param descendant Descendant
     */
    public void addElement(Element descendant) {
        descendants.add(descendant);
    }

    @Override
    public String toString() {
        return "{Element (" + number + ") #" + height + " " + descendants.toString() +"}";
    }
}
