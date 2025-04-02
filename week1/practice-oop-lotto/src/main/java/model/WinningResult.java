package model;

import global.Constants;

import java.util.HashMap;
import java.util.Map;

public class WinningResult implements MModel<Map<Constants.WinningRank, Integer>>{
    private final Map<Constants.WinningRank, Integer> winningCounts;

    public WinningResult(Map<Constants.WinningRank, Integer> winningCounts) {
        this.winningCounts = winningCounts;
    }

    @Override
    public Map<Constants.WinningRank, Integer> getData() {
        return new HashMap<>(winningCounts);
    }

    public int getCount(Constants.WinningRank rank) {
        return winningCounts.getOrDefault(rank, 0);
    }
}
