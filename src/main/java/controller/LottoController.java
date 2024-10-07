package controller;

import model.UserNumber;
import model.Lotto;
import model.RateCalculator;
import model.WinChecker;
import constants.ErrorMessage;
import view.LottoView;

import java.util.*;

public class LottoController {
    private UserNumber userNumber;
    private Lotto lotto;
    private WinChecker winChecker;
    private RateCalculator rateCalculator;
    private LottoView lottoView;
    private ErrorMessage errorMessage;


    public LottoController(UserNumber userNumber, Lotto lotto, WinChecker winChecker, RateCalculator rateCalculator,  LottoView lottoView, ErrorMessage errorMessage) {
        this.userNumber = userNumber;
        this.lottoView = lottoView;
        this.lotto = lotto;
        this.winChecker = winChecker;
        this.rateCalculator = rateCalculator;
        this.errorMessage = errorMessage;
    }

    public void run() {
        try {
            int money = lottoView.getMoneyInput();
            int lottoCount = userNumber.buy(money);
            lottoView.displayLottoCount(lottoCount);

            List<List<Integer>> lottos = new ArrayList<>();
            lottoView.displayLottoNumber(lottos);

            // 당첨 번호 및 보너스 번호 입력받기
            String winningNumber = lottoView.getWinningNumber();
            int bonusNumber = lottoView.getBonusNumber();
            lotto = new Lotto(winningNumber, bonusNumber);
            List<Integer> winningNumbers = lotto.split(winningNumber);// 보너스 번호 범위 확인
            winChecker = new WinChecker(winningNumbers, bonusNumber, lottos);

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
