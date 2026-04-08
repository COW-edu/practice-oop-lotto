package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Rank;
import lotto.Service.LottoResultService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;
import java.util.Map;

public class ApplicationController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoResultService lottoResultService = new LottoResultService();

    public void run() {
        // 1. 구입 금액 입력
        int money = inputView.inputMoney();

        // 2. 랜덤 로또 생성 및 출력
        Lotto lotto = new Lotto(money);
        outputView.printLottoCount(lotto.getCount());
        outputView.printLottos(lotto.getListLotto());

        // 3. 당첨 번호 입력
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        // 4. 보너스 번호 입력
        int bonusNum = inputView.inputBonus(winningNumbers);

        // 5. 당첨 계산
        Map<Rank, Integer> result = lottoResultService.calculate(
                lotto.getListLotto(), winningNumbers, bonusNum);

        // 6. 수익률 계산
        double profitRate = lottoResultService.calculateProfitRate(result, money);

        // 7. 결과 출력
        outputView.printResult(result);
        outputView.printProfitRate(profitRate);
    }
}
 