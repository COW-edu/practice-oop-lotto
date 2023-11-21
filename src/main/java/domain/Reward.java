package domain;

import java.util.ArrayList;
import java.util.List;
import Enum.Rank;
import lotto.Lotto;

public class Reward {

    private List<Lotto> lottos;
    private Lotto selectLotto;
    public double profit;

    public Reward() {

    }

    public void setReward(List<Lotto> lottos, Lotto selectLotto) {
        this.lottos = lottos;
        this.selectLotto = selectLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getSelectLotto() {
        return selectLotto;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }
}
