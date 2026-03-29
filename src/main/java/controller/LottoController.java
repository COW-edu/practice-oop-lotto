package controller;

import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import domain.Result;
import enums.Rank;
import view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        try {
            UserInput userInput = new UserInput();
            List<Lotto> purchasedLottos = purchaseLottos(userInput);
            Lotto winLotto = readWinningLotto(userInput);
            BonusNumber bonusNumber = readBonusNumber(userInput, winLotto);
            Result result = new Result(purchasedLottos, winLotto, bonusNumber);
            printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(UserInput userInput) {
        int lottoCount = new Amount(userInput.purchaseAmount()).getLottoCount();

        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = Lotto.random();
            purchasedLottos.add(lotto);
            System.out.println(lotto);
        }
        return purchasedLottos;
    }

    private Lotto readWinningLotto(UserInput userInput) {
        return new Lotto(userInput.winningNumbers());
    }

    private BonusNumber readBonusNumber(UserInput userInput, Lotto winLotto) {
        return new BonusNumber(userInput.bonusNumbers(), winLotto);
    }

    private void printResult(Result result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.FIFTH.getDisplayString() + result.getCount(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getDisplayString() + result.getCount(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getDisplayString() + result.getCount(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getDisplayString() + result.getCount(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getDisplayString() + result.getCount(Rank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getReturnRate());
    }
}
