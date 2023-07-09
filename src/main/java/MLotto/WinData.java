package MLotto;

import java.util.Map;

public class WinData {
    public enum WinLottoCount {
        threeCount("3",5000),
        fourCount("4",50000),
        fiveCount("5",1500000),
        fiveBonusCount("5.5",30000000),
        sixCount("6",2000000000);

        private String count;
        private int lottoWinningPrice;
        WinLottoCount(String count, int lottoWinningPrice){
            this.count =count;
            this.lottoWinningPrice =lottoWinningPrice;
        }
        public String getCount(){
            return this.count;
        }
        public int getLottoWinningPrice(){return this.lottoWinningPrice;}

    }
    private Map<String, Integer> winCountResult;
    private int[] equalCounts;
    private boolean[] bonusCounts;
    private double profitRateSecondPoint;
    private Lotto winLotto;
    private int bonusNum;

    public void setWinLotto(Lotto winLotto) {this.winLotto = winLotto;}

    public void setBonusNum(int bonusNum) {this.bonusNum = bonusNum;}

    public void setEqualCounts(int[] equalCounts) {
        this.equalCounts = equalCounts;
    }

    public void setBonusCounts(boolean[] bonusCounts) {
        this.bonusCounts = bonusCounts;
    }

    public void setWinCountResult(Map<String, Integer> winCountResult) {
        this.winCountResult = winCountResult;
    }

    public void setProfitRateSecondPoint(double profitRateSecondPoint) {this.profitRateSecondPoint = profitRateSecondPoint;}

    public Lotto getWinLotto() {return winLotto;}

    public int getBonusNum() {return bonusNum;}

    public int[] getEqualCounts() {return equalCounts;}

    public boolean[] getBonusCounts() {
        return bonusCounts;
    }

    public Map<String, Integer> getWinCountResult() {
        return winCountResult;
    }

    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}
}
