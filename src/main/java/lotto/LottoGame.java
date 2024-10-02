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
            // 사용자에게 구입 금액 받기
            int purchaseAmount = ui.inputPurchaseAmount();
            // 구입 금액에 해당하는 로또 티켓을 구매
            purchasedLottos = purchaseLottos(purchaseAmount);
            // 로또 티켓 출력
            ui.printPurchasedLottos(purchasedLottos);

            // 당첨 번호와 보너스 번호 입력 받고
            winningNumbers = ui.inputWinningNumbers();
            bonusNumber = ui.inputBonusNumber();

            // 결과 출력
            printResults();
        } catch (IllegalArgumentException e) {
            ui.printErrorMessage(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int amount) {
        // 구매할 로또의 수 계산
        int numberOfLottos = amount / Price;

        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> {
                    // 1~ 45 중에 6개의 숫자를 무작위로 선택
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Collections.sort(numbers);
                    return new Lotto(numbers);
                })
                .collect(Collectors.toList());
    }


    private void printResults() {
        int[] results = new int[Rank.values().length];

        for (Lotto lotto : purchasedLottos) { // 구매한 로또 티켓을 순회 하면서..
            int matchCount = getMatchCount(lotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            // 일치하는 번호 개수와 보너스 여부로 Rank 결정
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
