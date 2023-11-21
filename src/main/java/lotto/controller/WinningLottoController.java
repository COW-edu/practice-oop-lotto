package lotto.controller;

import lotto.config.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningLottoController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final WinningLotto winningLotto;


    private static final int RANKING_LIST_SIZE = 8;
    private static final int SELECTED_SECOND_RANK_KEY = 5;
    private static final int SECOND_RANK_KEY = 7;
    private static final String SPLIT_UNIT = ",";

    public WinningLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winningLotto = new WinningLotto();
    }

    @Override
    public void service(Map<String, Object> model) {

        List<Lotto> selectedLottoNumList = (List<Lotto>) model.get("Lotto");
        int purchaseMoney = (int) model.get("Purchase");


        List<Integer> winningNumber = convertWinningNumber(inputView.inputWinningNum());
        int bonusNumber = inputView.inputBonus();

        int[] checkedRankList = compareLottoNumber(selectedLottoNumList, winningNumber, bonusNumber);

        outputView.outputWinningStatistic(checkedRankList);
        outputView.outputMoneyPercent(calculateEarningRate(checkedRankList, purchaseMoney));
    }


    private void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumList) {
        if (winningNumList.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    public int[] compareLottoNumber(List<Lotto> selectedLottoNumList, List<Integer> winningNumList, int bonusNum) {
        validateBonusNumberDuplicate(bonusNum, winningNumList);

        List<Integer> tempList;
        int[] checkedRankList = new int[RANKING_LIST_SIZE];

        for (Lotto lotto : selectedLottoNumList) {
            List<Integer> tempSelected = lotto.getLottoList();

            tempList = tempSelected.stream()
                    .filter(o -> winningNumList.stream().anyMatch(Predicate.isEqual(o)))
                    .collect(Collectors.toList());

            checkedRankList[tempList.size()]++;

            if (tempList.size() == SELECTED_SECOND_RANK_KEY && tempSelected.contains(bonusNum)) {
                checkedRankList[SECOND_RANK_KEY]++;
            }
        }
        return checkedRankList;
    }

    public ArrayList<Integer> convertWinningNumber(String winngingNumberString) {
        ArrayList<Integer> winningNumber = new ArrayList<>();

        String[] tempStr = winngingNumberString.split(SPLIT_UNIT);
        for (String temp : tempStr) {
            winningNumber.add(Integer.parseInt(temp));
        }
        winningLotto.setWinningNumlist(winningNumber);
        return winningNumber;
    }

    public double calculateEarningRate(int[] checkedRankList, int purchaseMoney) {
        double tempSum = 0.0;

        for (int i = 3; i < checkedRankList.length; i++) {
            if (checkedRankList[i] != 0 && i == 3) {
                tempSum += checkedRankList[i] * Prize.FIFTH.getWinningMoney();
            }
            if (checkedRankList[i] != 0 && i == 4) {
                tempSum += checkedRankList[i] * Prize.FOURTH.getWinningMoney();
            }
            if (checkedRankList[i] != 0 && i == 5) {
                tempSum += checkedRankList[i] * Prize.THIRD.getWinningMoney();
            }
            if (checkedRankList[i] != 0 && i == 6) {
                tempSum += checkedRankList[i] * Prize.FIRST.getWinningMoney();
            }
            if (checkedRankList[i] != 0 && i == 7) {
                tempSum += checkedRankList[i] * Prize.SECOND.getWinningMoney();
            }
        }
        double resultPercent = Math.round(tempSum / (double) purchaseMoney * 100.0) / 100.0 * 100;

        return resultPercent;
    }


}
