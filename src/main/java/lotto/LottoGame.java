package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final UserInterFace ui = new UserInterFace();
    private static final int Price = 1000;
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
        int numberOfLottos = amount / Price;

        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> {
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Collections.sort(numbers);
                    return new Lotto(numbers);
                })
                .collect(Collectors.toList());
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
