package controller;

import model.LottoNumber;
import model.Lotto;
import model.RateCalculator;
import model.WinChecker;
import valueObject.ErrorMessage;
import view.LottoView;

import java.util.*;

public class LottoController {
    private LottoNumber lottoNumber;
    private Lotto mLotto;
    private WinChecker winChecker;
    private RateCalculator rateCalculator;
    private LottoView lottoView;
    private ErrorMessage errorMessage;


    public LottoController(LottoNumber lottoNumber, LottoView lottoView) {
        this.lottoNumber = lottoNumber;
        this.lottoView = lottoView;
    }

    public void run() {
        try {
            int money = lottoView.getMoneyInput();
            int lottoCount = lottoNumber.buy(money);
            lottoView.displayLottoCount(lottoCount);

            List<List<Integer>> lottosList = new ArrayList<>();
            for (int i = 0; i < lottoCount; i++) {
                List<Integer> lottoNumbersList = lottoNumber.create();
                lottoView.displayLottoNumber(lottoNumbersList);
                lottosList.add(lottoNumbersList);
            }

            // 당첨 번호 및 보너스 번호 입력받기
            String winningNumber = lottoView.getWinningNumber();
            List<Integer> winningNumberList = mLotto.splitNumbers(winningNumber);
            mLotto = new Lotto(winningNumberList);
            int bonusNumber = lottoView.getBonusNumber();
            lottoNumber.validate(bonusNumber); // 보너스 번호 범위 확인
            winChecker = new WinChecker(winningNumberList, bonusNumber, lottosList);

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


        } catch (NumberFormatException e) {
            System.err.println(errorMessage.ERROR_NUM);
        } catch (IllegalArgumentException e) {
            System.err.println(errorMessage.ERROR_COUNT);
        }
    }
}
