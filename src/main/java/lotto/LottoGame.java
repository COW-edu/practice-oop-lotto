package lotto;

import java.util.List;

public class LottoGame {

    private final InputHandler inputHandler;
    private final LottoGenerator lottoGenerator;
    private final ResultCalculator resultCalculator;
    private final OutputHandler outputHandler;

    public static final int LOTTO_PRICE = 1000;

    public LottoGame() {
        this.inputHandler = new InputHandler();
        this.lottoGenerator = new LottoGenerator();
        this.resultCalculator = new ResultCalculator();
        this.outputHandler = new OutputHandler();
    }

    public void start() {
        // 구입 금액 입력
        int money = inputHandler.getMoney();
        int lottoCount = money / LOTTO_PRICE;

        // 로또 번호 자동 생성
        List<Lotto> boughtLottos = lottoGenerator.generateLottos(lottoCount);

        // 구매한 로또 출력
        outputHandler.printLottos(boughtLottos);

        // 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);

        // 당첨 결과 계산 및 출력
        int[] matchCounts = resultCalculator.calculateResults(boughtLottos, winningNumbers, bonusNumber);
        outputHandler.printStatistics(matchCounts, lottoCount * LOTTO_PRICE);
    }
}
