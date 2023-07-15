package model;

import java.util.Map;

public class WinData {
    private Map<String, Integer> winCountResult;
    private int[] equalCounts;
    private boolean[] bonusCounts;
    private double profitRateSecondPoint;
    private Lotto winLotto;
    private int bonusNumber;

    public void setWinLotto(Lotto winLotto) {this.winLotto = winLotto;}

    public void setBonusNumber(int bonusNumber) {this.bonusNumber = bonusNumber;}

    public void setEqualCounts(int[] equalCounts) {
        this.equalCounts = equalCounts;
    }

    public void setBonusCounts(boolean[] bonusCounts) {
        this.bonusCounts = bonusCounts;
    }

    public void setWinCountResult(Map<String, Integer> winCountResult) {this.winCountResult = winCountResult;}

    public void setProfitRateSecondPoint(double profitRateSecondPoint) {this.profitRateSecondPoint = profitRateSecondPoint;}

    public Lotto getWinLotto() {return winLotto;}

    public int getBonusNumber() {return bonusNumber;}

    public int[] getEqualCounts() {return equalCounts;}

    public boolean[] getBonusCounts() {
        return bonusCounts;
    }

    public Map<String, Integer> getWinCountResult() {
        return winCountResult;
    }

    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}
}
