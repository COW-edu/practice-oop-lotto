package model;

import java.util.List;

public class WinCheck {
    private final List<Integer> winNumber;
    private final List<List<Integer>> userNumber;

    private int threeNum;
    private int fourNum;
    private int fiveNum;
    private int sixNum;

    public WinCheck(List<Integer> winNumber, List<List<Integer>> userNumber) {
        this.winNumber = winNumber;
        this.userNumber = userNumber;

        winChecker(winNumber, userNumber);
        winStats();
    }
    private void winChecker(List<Integer> winNumber, List<List<Integer>> userNumber) {
        for (List<Integer> userNum : userNumber) {
            userNum.retainAll(winNumber);
            if (userNum.size() == 3) {
                threeNum++;
            } else if (userNum.size() == 4) {
                fourNum++;
            } else if (userNum.size() == 5) {
                fiveNum++;
            } else if (userNum.size() == 6) {
                sixNum++;
            }
        }
    }
    private void winStats() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+threeNum+"개");
        System.out.println("4개 일치 (50,000원) - "+fourNum+"개");
        System.out.println("5개 일치 (1,500,000원) - "+fiveNum+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+sixNum+"개");
    }
}
