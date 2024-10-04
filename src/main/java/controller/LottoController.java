package controller;

import model.LottoNum;
import model.Lotto;
import model.RateCalculator;
import model.WinChecker;
import valueObject.ErrorMessage;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private LottoNum lottoNum;
    private Lotto mLotto;
    private WinChecker winChecker;
    private RateCalculator rateCalculator;
    private LottoView lottoView;
    private ErrorMessage errorMessage;


    public LottoController(LottoNum lottoNum, LottoView lottoView) {
        this.lottoNum = lottoNum;
        this.lottoView = lottoView;
    }

    public void run() {
        int money = lottoView.getMoneyInput();
        int lottoCount = lottoNum.buyLotto(money);
        lottoView.displayLottoCount(lottoCount);

        List<List<Integer>> userLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = lottoNum.lottoNumbers();
            lottoView.displayLottoNumber(lottoNumbers);
            userLottos.add(lottoNumbers);
        }

        try {
            // 당첨 번호 및 보너스 번호 입력받기
            String winningNumber = lottoView.getWinningNumber();
            List<Integer> winningNumberList = lottoNum.splitNum(winningNumber);
            mLotto = new Lotto(winningNumberList);
            int bonusNumber = lottoView.getBonusNumber();
            lottoNum.validate(bonusNumber); // 보너스 번호 범위 확인
            winChecker = new WinChecker(winningNumberList, bonusNumber, userLottos);
        } catch (NumberFormatException e) {
            System.err.println(errorMessage.ERROR_NUM);
        } catch (IllegalArgumentException e) {
            System.err.println(errorMessage.ERROR_COUNT);
        }
        int threeCount = winChecker.getThreeCount();
        int fourCount = winChecker.getFourCount();
        int fiveCount = winChecker.getFiveCount();
        int fiveBonusCount = winChecker.getFiveBonusCount();
        int sixCount = winChecker.getSixCount();
        // 당첨 통계 보여주는 메서드에 WinChecker의 당첨 정보 넘겨주기
        lottoView.displayWinningList(threeCount, fourCount, fiveCount, fiveBonusCount, sixCount);
        // 수익률 계산
        rateCalculator = new RateCalculator();
        int totalMoney = rateCalculator.calculateWinMoney(threeCount, fourCount, fiveCount, fiveBonusCount, sixCount);
        lottoView.displayReturn(rateCalculator.calculateRate(money, totalMoney));
    }
}
