package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    List<Lotto> lottoList = new ArrayList<>();
    List<Integer> winNumber;
    int bonusNumber;
    int profit;
    double profitRate;

    // 3, 4, 5, 6, Bonus
    int[] winResult = {0, 0, 0, 0, 0};
    int purchasePrice;
    int purchaseAmount;

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLotto() {
        return lottoList;
    }

    public void setWinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }

    public List<Integer> getWinNumber() {
        return this.winNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setWinResult(int[] winResult) {
        this.winResult = winResult;
    }

    public int[] getWinResult() {
        return winResult;
    }

    public void setProfit(int profit) {
        this.profit = profit;
        profitRate = profit / (double) purchasePrice;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
