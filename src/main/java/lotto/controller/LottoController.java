package lotto.controller;

import lotto.Lotto;
import lotto.config.WinningPrint;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoController {

    private static int PURCHASE_PRICE = 1000;
    private static int WINNING_KEY = 7;

    private final InputView inputView;
    private final OutputView outputView;
    private Lotto lotto;
    private final LottoService lottoService;

    // field Element
    private int purchaseMoney;
    public int purchaseAmount;
    public int inputBonusNum;
    private List<Integer> member;
    private List<Lotto> selectedLottoNumList;
    private List<Integer> winningNumList;
    private int[] checkedRankList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        // 서비스 의존
        this.lottoService = new LottoService();

        // service
        this.lotto = new Lotto(member);
        WinningPrint winningPrint;
    }


    public void lottoGameRun() {
        // winningNum에 대한 vaildation 작성 해야함
        /*
      - validation 처리 해야 됨
      1. 정수 입력
      2. 1~45 수
      3. winningNum 중복
       */

        // 레츠고고고고고고고고
        this.purchaseMoney = inputView.inputPurchaseMoney();
        this.purchaseAmount = this.lottoService.validatePurchaseAmount(this.purchaseMoney);
        outputView.outputLottoAmount(this.purchaseAmount);
        this.selectedLottoNumList = lottoService.createMember(this.purchaseAmount);
        this.outputView.outputSelectedLottoNum(this.selectedLottoNumList);
        this.winningNumList = lottoService.convertWinningNum(this.inputView.inputWinningNum());
        this.inputBonusNum = inputView.inputBonus();
        this.checkedRankList = lottoService.checkNum(selectedLottoNumList, winningNumList, inputBonusNum);
        this.outputView.outputWinningStatistic(this.checkedRankList);
        this.outputView.outputMoneyPercent(lottoService.calEarningRate(this.checkedRankList, this.purchaseMoney));

    }
}
