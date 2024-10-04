package model;

import java.util.List;
import java.util.ArrayList;

public class WinChecker {
    private final List<Integer> winNumber;
    private final List<List<Integer>> userNumbers;
    private final Integer bonusNumber;

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int fiveBonusCount;
    private int sixCount;

    public WinChecker(List<Integer> winNumber, int bonusNumber, List<List<Integer>> userNumbers) {
        this.winNumber = winNumber;
        this.userNumbers = userNumbers;
        this.bonusNumber = bonusNumber;

        winChecker(winNumber, bonusNumber, userNumbers);
    }
    private void winChecker(List<Integer> winNumber, int bonusNumber, List<List<Integer>> userNumbers) {
        for (List<Integer> userNum : userNumbers) {
            List<Integer> matchedNumbers = new ArrayList<>(userNum);
            matchedNumbers.retainAll(winNumber);

            if (matchedNumbers.size() == 3) {
                threeCount++;
            } else if (matchedNumbers.size() == 4) {
                fourCount++;
            } else if (matchedNumbers.size() == 5) {
                if (userNum.contains(bonusNumber)) {
                    fiveBonusCount++;
                } else {
                    fiveCount++;
                }
            } else if (matchedNumbers.size() == 6) {
                sixCount++;
            }
        }
    }
    public int getThreeCount() {
        return threeCount;
    }
    public int getFourCount() {
        return fourCount;
    }
    public int getFiveCount() {
        return fiveCount;
    }
    public int getFiveBonusCount() {
        return fiveBonusCount;
    }
    public int getSixCount() {
        return sixCount;
    }
}
