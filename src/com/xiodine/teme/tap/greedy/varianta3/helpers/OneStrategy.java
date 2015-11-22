package com.xiodine.teme.tap.greedy.varianta3.helpers;

import java.util.List;

/**
 * File created at: 11/21/15 - 12:00 PM
 */
public interface OneStrategy<ListT, PickT extends List<ListT>, ReturnT> {


    /**
     * Selects an item with the implemented helpers.
     *
     * @param oldElements Elements list
     * @return Element selected
     */
    ReturnT select(PickT oldElements);

    /**
     * @param elements Elements list
     * @return True if can select another element
     */
    boolean canSelect(PickT elements);

}
