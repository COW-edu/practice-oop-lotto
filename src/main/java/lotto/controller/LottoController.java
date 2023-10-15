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
    public int bonusNumber;
    private List<Lotto> selectedLottoNumList;
    private List<Integer> winningNumber;
    private int[] checkedRankList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }


    public void lottoGameRun() {
        // let's go
        purchaseMoney = inputView.inputPurchaseMoney();
        purchaseAmount = lottoService.calculatePurchaseAmount(purchaseMoney);
        outputView.outputLottoAmount(purchaseAmount);

        this.selectedLottoNumList = lottoService.createLottoMember(purchaseAmount);
        this.outputView.outputSelectedLottoNum(selectedLottoNumList);

        this.winningNumber = lottoService.convertWinningNumber(inputView.inputWinningNum());
        this.bonusNumber = inputView.inputBonus();

        this.checkedRankList = lottoService.compareLottoNumber(selectedLottoNumList, winningNumber, bonusNumber);

        this.outputView.outputWinningStatistic(checkedRankList);
        this.outputView.outputMoneyPercent(lottoService.calculateEarningRate(checkedRankList, purchaseMoney));
    }

}
