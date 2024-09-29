package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final UserInterface ui = new UserInterface();
    private List<Lotto> purchasedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void start() {
        try {
            int purchaseAmount = ui.inputPurchaseAmount();
            purchasedLottos = purchaseLottos(purchaseAmount);
            ui.printPurchasedLottos(purchasedLottos);

            winningNumbers = ui.inputWinningNumbers();
            bonusNumber = ui.inputBonusNumber();

            printResults();
        } catch (IllegalArgumentException e) {
            ui.printErrorMessage(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int amount) {
        int numberOfLottos = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printResults() {
        int[] results = new int[Rank.values().length];

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results[rank.ordinal()]++;
        }

        ui.printStatistics(results, Rank.values());
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
