package model;

import java.util.List;
import java.util.ArrayList;

public class WinCheck {
    private final List<Integer> winNumber;
    private final List<List<Integer>> userNumbers;
    private final Integer bonusNumber;

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int fiveBonusCount;
    private int sixCount;

    public WinCheck(List<Integer> winNumber, int bonusNumber, List<List<Integer>> userNumbers) {
        this.winNumber = winNumber;
        this.userNumbers = userNumbers;
        this.bonusNumber = bonusNumber;

        winChecker(winNumber, bonusNumber, userNumbers);
        winStats();
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
    private void winStats() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ threeCount +"개");
        System.out.println("4개 일치 (50,000원) - "+ fourCount +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ fiveCount +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ fiveBonusCount +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ sixCount +"개");
    }
}
