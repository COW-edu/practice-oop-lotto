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
    private int purchaseAmount;
    private int bonusNumber;
    private List<Lotto> selectedLottoNumList;
    private List<Integer> winningNumber;
    private int[] checkedRankList;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }


    public void lottoGameRun() {
        // let's go
        purchaseMoney = inputView.inputPurchaseMoney();
        purchaseAmount = lottoService.calculatePurchaseAmount(purchaseMoney);
        outputView.outputLottoAmount(purchaseAmount);

        selectedLottoNumList = lottoService.createLottoMember(purchaseAmount);
        outputView.outputSelectedLottoNum(selectedLottoNumList);

        winningNumber = lottoService.convertWinningNumber(inputView.inputWinningNum());
        bonusNumber = inputView.inputBonus();

        checkedRankList = lottoService.compareLottoNumber(selectedLottoNumList, winningNumber, bonusNumber);

        outputView.outputWinningStatistic(checkedRankList);
        outputView.outputMoneyPercent(lottoService.calculateEarningRate(checkedRankList, purchaseMoney));
    }

}
