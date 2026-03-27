package lotto;

import lotto.domain.LottoIssuer;
import lotto.domain.LottoResultCalculator;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLotto;
import lotto.parser.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
        }
    }

    private static void run() {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = issueLottos(purchaseAmount);
        WinningLotto winningLotto = readWinningLotto();
        LottoStatistics statistics = calculateStatistics(purchasedLottos, winningLotto);
        OutputView.printStatistics(statistics, statistics.calculateProfitRate(purchaseAmount));
    }

    private static int readPurchaseAmount() {
        return InputParser.parsePurchaseAmount(InputView.readPurchaseAmount());
    }

    private static List<Lotto> issueLottos(int purchaseAmount) {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> purchasedLottos = lottoIssuer.issue(purchaseAmount);
        OutputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static WinningLotto readWinningLotto() {
        List<Integer> winningNumbers = InputParser.parseWinningNumbers(InputView.readWinningNumbers());
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = InputParser.parseBonusNumber(InputView.readBonusNumber());
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static LottoStatistics calculateStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResultCalculator calculator = new LottoResultCalculator();
        return calculator.calculate(purchasedLottos, winningLotto);
    }
}
