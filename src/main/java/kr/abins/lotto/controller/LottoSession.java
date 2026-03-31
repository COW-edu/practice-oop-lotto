package kr.abins.lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import kr.abins.lotto.Constants;
import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoPrize;
import kr.abins.lotto.model.LottoRecipe;
import kr.abins.lotto.view.LottoWriter;
import kr.abins.lotto.view.LottoReader;

import java.util.*;

public class LottoSession {

    private int purchaseAmount;
    private List<Integer> winningNumbers;
    private int bonus;
    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<LottoPrize, List<LottoRecipe>> recipes = new HashMap<>();

    public LottoSession() {}

    public void start() {
        final int count = this.purchaseAmount0();
        this.purchase(count);

        LottoWriter.printWinningNumbersMessage();
        this.winningNumbers = LottoReader.readWinningNumbers();

        LottoWriter.printBonusNumberMessage();
        this.bonus = LottoReader.readBonusNumber();
        LottoReader.validateBonusNumber(this.bonus, this.winningNumbers);

        LottoWriter.printNewLine();
        for (final Lotto lotto : this.lottos) {
            this.matchingLotto(lotto);
        }
    }

    private void matchingLotto(final Lotto lotto) {
        LottoPrize.find(this.winningNumbers, this.bonus, lotto)
            .ifPresent(prize -> this.recipes.computeIfAbsent(prize, k -> new ArrayList<>())
                .add(new LottoRecipe(lotto, prize)));
    }

    private void purchase(final int count) {
        LottoWriter.printPurchaseCount(count);

        for (int index = 0; index < count; index++) {
            final List<Integer> randomNumbers = this.pickRandomNumbers();
            LottoWriter.printLottoNumbers(randomNumbers);

            final Lotto lotto = new Lotto(randomNumbers);
            this.lottos.add(lotto);
        }
    }

    private int purchaseAmount0() {
        LottoWriter.printPurchaseAmountMessage();

        final int purchaseAmount = LottoReader.readPurchaseAmount();
        this.purchaseAmount = purchaseAmount;
        final int count = purchaseAmount / Constants.LOTTO_PRICE;
        LottoWriter.printNewLine();

        return count;
    }

    private List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.LOTTO_NUMBER_COUNT
        );
    }

    public int purchaseAmount() {
        return this.purchaseAmount;
    }

    public List<Integer> winningNumbers() {
        return this.winningNumbers;
    }

    public int bonus() {
        return this.bonus;
    }

    public List<Lotto> lottos() {
        return this.lottos;
    }

    public Map<LottoPrize, List<LottoRecipe>> recipes() {
        return this.recipes;
    }
}
