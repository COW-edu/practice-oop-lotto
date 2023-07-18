package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WalletImpl {
    private static final int THREE_ACCORD_REWARD = 5000;
    private static final int FOUR_ACCORD_REWARD = 50000;
    private static final int FIVE_ACCORD_REWARD = 1500000;
    private static final int BONUS_ACCORD_REWARD = 30000000;
    private static final int SIX_ACCORD_REWARD = 2000000000;

    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> winNumber;
    private int bonusNumber;
    private int profit;
    private double profitRate;

    private final int purchasePrice;

    // 3, 4, 5, 6, Bonus
    int[] winResult = {0, 0, 0, 0, 0};

    public WalletImpl(List<Lotto> lottoList, List<Integer> winNumber, int bonusNumber, int purchaseAmount) {
        this.lottoList = lottoList;
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
        this.purchasePrice = purchaseAmount*1000;
        calculateProfitRate();
        calculateWinResult();
    }

    private void calculateProfitRate() {
        profitRate = profit / (double) purchasePrice;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void calculateWinResult() {
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();

            int accordWinNumber = 0;
            int accordBonusNumber = 0;

            for (Integer number : numbers) {
                if (winNumber.contains(number)) {
                    accordWinNumber += 1;
                }
                if (number == bonusNumber) {
                    accordBonusNumber += 1;
                }
            }

            if (accordWinNumber >= 3) {
                if (accordWinNumber == 5 && accordBonusNumber == 1) {
                    winResult[4] += 1;
                }
                winResult[accordWinNumber - 3] += 1;
            }
        }
        profit = winResult[0]*THREE_ACCORD_REWARD + winResult[1]*FOUR_ACCORD_REWARD + winResult[2]*FIVE_ACCORD_REWARD + winResult[3]*SIX_ACCORD_REWARD + winResult[4]*BONUS_ACCORD_REWARD;
    }

    public int[] getWinResult() {
        return winResult;
    }
}
