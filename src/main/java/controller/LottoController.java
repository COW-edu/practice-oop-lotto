package controller;

import domain.*;
import util.Parser;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private final InputView userInput;
    private final OutputView userOutput;

    public LottoController(InputView userInput, OutputView userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    public void run() {
        try {
            PurchaseAmount amount = receiveAmount();

            List<Lotto> purchasedLottos = purchase(amount);

            Result result = calculateResult(purchasedLottos);

            // 8. 당첨결과 출력
            userOutput.printResult(result);

        } catch (IllegalArgumentException e) {
            userOutput.printErrorMessage(e.getMessage());
        }
    }

    // 3. 입력받은 구입금액 파싱 후 넘겨줘서 검증 - 천원단위, 양수
    private PurchaseAmount receiveAmount() {
        return new PurchaseAmount(Parser.parseSingleNumber(userInput.purchaseAmount()));
    }

    // 4. 로또 개수 파악 및 로또 객체 생성 후 출력
    private List<Lotto> purchase(PurchaseAmount amount) {
        int count = amount.getLottoCount();
        userOutput.printPurchaseCount(count);

        List<Lotto> lottos = Stream.generate(Lotto::createRandomLotto)
                .limit(count)
                .collect(Collectors.toList());

        userOutput.printLottos(lottos);
        return lottos;
    }

    private Result calculateResult(List<Lotto> purchasedLottos) {
        // 5. 당첨번호 및 보너스번호 입력받은 후 파싱
        Lotto winLotto = new Lotto(Parser.parseNumbers(userInput.winningNumbers()));
        BonusNumber bonusNumber = new BonusNumber(Parser.parseSingleNumber(userInput.bonusNumbers()));
        // 6. WinningLotto클래스로
        WinningLotto winningLotto = new WinningLotto(winLotto, bonusNumber);
        // 7. 당첨 확인 및 수익률 확인
        return new Result(purchasedLottos, winningLotto);
    }
}