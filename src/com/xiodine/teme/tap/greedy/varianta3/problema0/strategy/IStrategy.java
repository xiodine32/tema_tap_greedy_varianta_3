package com.xiodine.teme.tap.greedy.varianta3.problema0.strategy;

/**
 * File created at: 11/21/15 - 12:00 PM
 */
public interface IStrategy<PickT, ReturnT> {
    ReturnT select(PickT oldElements, ReturnT competitionPick);

    boolean canSelect(PickT elements);
}
