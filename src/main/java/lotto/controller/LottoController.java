package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.readPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> lottos = issueLottos(ticketCount);
        OutputView.printPurchased(ticketCount, lottos);

        WinningNumbers winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        winningNumbers = winningNumbers.withBonus(bonusNumber);

        OutputView.printStatisticsHeader();
        final WinningNumbers finalWinningNumbers = winningNumbers;
        List<Rank> results = lottos.stream()
                .map(lotto -> finalWinningNumbers.evaluate(lotto))
                .collect(Collectors.toList());
        OutputView.printRanks(results);
        double yieldPercent = calculateYieldPercent(purchaseAmount, results);
        OutputView.printYield(yieldPercent);
    }

    private List<Lotto> issueLottos(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> generated = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(generated);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private double calculateYieldPercent(int purchaseAmount, List<Rank> results) {
        long totalPrize = 0L;
        for (Rank rank : results) {
            totalPrize += rank.getPrize();
        }
        double yield = (double) totalPrize / purchaseAmount * 100.0;
        return Math.round(yield * 10.0) / 10.0;
    }
}


