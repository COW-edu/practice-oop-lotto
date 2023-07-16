package model.win;

import java.util.Map;
import model.lotto.Lotto;

public class WinData {
    private Map<String, Integer> winCountResult;
    private double profitRateSecondPoint;
    private Lotto winLotto;
    private int bonusNumber;

    public void setWinLotto(Lotto winLotto) {this.winLotto = winLotto;}

    public void setBonusNumber(int bonusNumber) {this.bonusNumber = bonusNumber;}

    public void setWinCountResult(Map<String, Integer> winCountResult) {this.winCountResult = winCountResult;}

    public void setProfitRateSecondPoint(double profitRateSecondPoint) {this.profitRateSecondPoint = profitRateSecondPoint;}

    public Lotto getWinLotto() {return winLotto;}

    public int getBonusNumber() {return bonusNumber;}

    public Map<String, Integer> getWinCountResult() {
        return winCountResult;
    }

    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}
}
