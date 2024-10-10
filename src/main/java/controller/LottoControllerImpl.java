package controller;

import model.UserLottoImpl;
import model.LottoImpl;
import model.RateCalculatorImpl;
import model.WinCheckerImpl;
import constants.ErrorMessage;
import view.InputViewImpl;
import view.OutputViewImpl;

import java.util.*;

public class LottoControllerImpl implements LottoController {
    private UserLottoImpl userLottoImpl;
    private LottoImpl lotto;
    private final InputViewImpl inputViewImpl;
    private final OutputViewImpl outputViewImpl;

    private ErrorMessage errorMessage;


    public LottoControllerImpl(InputViewImpl inputViewImpl, OutputViewImpl outputViewImpl) {
        this.inputViewImpl = inputViewImpl;
        this.outputViewImpl = outputViewImpl;
    }

    public void run() {
        try {
            int money = inputViewImpl.getMoneyInput();
            UserLottoImpl userLottoImpl = new UserLottoImpl();
            int lottoCount = userLottoImpl.buy(money);
            outputViewImpl.displayLottoCount(lottoCount);
            List<List<Integer>> userLottoList = getUserLottoList(money);
            outputViewImpl.displayLottoNumber(userLottoList);

            String winningNumbers = inputViewImpl.getWinningNumber();
            int bonusNumber = inputViewImpl.getBonusNumber();
            List<Integer> winningLotto = getWinningLotto(winningNumbers, bonusNumber);

            Map<Integer, Integer> matchCountStatistics = checkWin(userLottoList, winningLotto, bonusNumber);
            outputViewImpl.displayWinningList(matchCountStatistics);

            RateCalculatorImpl rateCalculatorImpl = new RateCalculatorImpl(matchCountStatistics);
            int totalMoney = rateCalculatorImpl.calculateWinMoney();
            outputViewImpl.displayReturn(rateCalculatorImpl.calculateRate(money, totalMoney));
        } catch (NumberFormatException e) {
            System.err.println(errorMessage.ERROR_NUM);
        } catch (IllegalArgumentException e) {
            System.err.println(errorMessage.ERROR_COUNT);
        }
    }

    public List<List<Integer>> getUserLottoList(int money) {
        UserLottoImpl userLottoImpl = new UserLottoImpl();
        return userLottoImpl.createLottosList(userLottoImpl.buy(money));
    }
    public List<Integer> getWinningLotto(String winningNumbers, int bonusNumber) {
        LottoImpl lotto = new LottoImpl(winningNumbers, bonusNumber);
        return lotto.split(winningNumbers);
    }
    public Map<Integer, Integer> checkWin(List<List<Integer>> userLottoList, List<Integer> winningLotto, int bonusNumber) {
        Map<Integer, Integer> matchCountStatistics = new HashMap<>();
        matchCountStatistics.put(3, 0);
        matchCountStatistics.put(4, 0);
        matchCountStatistics.put(5, 0);
        matchCountStatistics.put(6, 0);
        matchCountStatistics.put(1, 0);

        for (List<Integer> userLotto : userLottoList) {
            WinCheckerImpl winCheckerImpl = new WinCheckerImpl(userLotto, winningLotto, bonusNumber);
            winCheckerImpl.getWinInfo(matchCountStatistics, winCheckerImpl.winCheck());
        }
        return matchCountStatistics;
    }
}
