package lotto.controller;

import lotto.Domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    // field Element
    private int purchaseMoney;
    public int purchaseAmount;
    public int bonusNum;
    private List<Lotto> selectedLottoNumList;
    private List<Integer> winningNumList;
    private int[] checkedRankList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }


    public void lottoGameRun() {
        // winningNum에 대한 vaildation 작성 해야함
        /*
          - validation 처리 해야 됨
          1. 정수 입력
          2. 1~45 수
          3. winningNum 중복
       */

        // let's go
        this.purchaseMoney = inputView.inputPurchaseMoney();
        this.purchaseAmount = this.lottoService.calculatePurchaseAmount(this.purchaseMoney);
        outputView.outputLottoAmount(this.purchaseAmount);

        this.selectedLottoNumList = lottoService.createMember(this.purchaseAmount);
        this.outputView.outputSelectedLottoNum(this.selectedLottoNumList);

        this.winningNumList = lottoService.convertWinningNum(this.inputView.inputWinningNum());
        this.bonusNum = inputView.inputBonus();

        this.checkedRankList = lottoService.checkNum(selectedLottoNumList, winningNumList, bonusNum);

        this.outputView.outputWinningStatistic(this.checkedRankList);
        this.outputView.outputMoneyPercent(lottoService.calEarningRate(this.checkedRankList, this.purchaseMoney));
    }

}
