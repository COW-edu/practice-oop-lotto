package kr.abins.lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSession {

    private int bonus;
    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();
    private Map<LottoPrize, List<LottoRecipe>> recipes = new HashMap<>();

    public LottoSession() {}


    public int purchaseAmount() {
        return this.purchaseAmount;
    }

    public void purchaseAmount(final int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public List<Integer> winningNumbers() {
        return this.winningNumbers;
    }

    public void winningNumbers(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int bonus() {
        return this.bonus;
    }

    public void bonus(final int bonus) {
        this.bonus = bonus;
    }

    public List<Lotto> lottos() {
        return this.lottos;
    }

    public void lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoPrize, List<LottoRecipe>> recipes() {
        return this.recipes;
    }

    public void recipes(final Map<LottoPrize, List<LottoRecipe>> recipes) {
        this.recipes = recipes;
    }
}
