package model;

import java.util.*;

public class WinCheckerImpl implements WinChecker {
    private final List<Integer> userLotto;
    private final List<Integer> winLotto;
    private final Integer bonusNumber;

    private static final int THREE_COUNT = 3;
    private static final int FOUR_COUNT = 4;
    private static final int FIVE_COUNT = 5;
    private static final int BONUS_COUNT = 1;
    private static final int SIX_COUNT = 6;

    public WinCheckerImpl(List<Integer> userLotto, List<Integer> winLotto, int bonusNumber) {
        this.userLotto = userLotto;
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public int winCheck() {
        List<Integer> matchedNumbers = new ArrayList<>(userLotto);
        matchedNumbers.retainAll(winLotto);
        return matchedNumbers.size();
    }

    public boolean isBonus() {
        return userLotto.contains(bonusNumber);
    }

    public void getWinInfo(Map<Integer, Integer> matchCountStatistics, int matchCount) {
        if (matchCount == FIVE_COUNT && isBonus()) {
            matchCountStatistics.put(BONUS_COUNT, matchCountStatistics.getOrDefault(BONUS_COUNT, 0) + 1);
        } else if (matchCount >= THREE_COUNT) {
            matchCountStatistics.put(matchCount, matchCountStatistics.getOrDefault(matchCount, 0) + 1);
        }
    }
}
