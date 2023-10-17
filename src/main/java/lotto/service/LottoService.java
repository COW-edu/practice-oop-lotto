package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.WinningLotto;
import lotto.config.ErrorMessage;
import lotto.Domain.Prize;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    // MAGIC NUMBER
    private static final int PURCHASE_PRICE = 1000;
    private static final int SECOND_RANK_KEY = 7;
    private static final int LOTTO_LIST_SIZE = 6;
    private static final int LOTTO_NUMBER_RANGE_FRONT = 1;
    private static final int LOTTO_NUMBER_RANGE_BACK = 45;
    private static final int RANKING_LIST_SIZE = 8;
    private static final int SELECTED_SECOND_RANK_KEY = 5;
    private static final String SPLIT_UNIT = ",";

    // components
    private final WinningLotto winningLotto;

    public LottoService() {
        this.winningLotto = new WinningLotto();
    }

    // validation
    private void validatePurchase(int purchaseMoney) {
        validatePurchaseAmount(purchaseMoney);
        validatePurchaseMinimumMoney(purchaseMoney);
    }


    private void validatePurchaseAmount(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_MONEY_NO_DIVISION.getErrorMessage());
        }
    }

    private void validatePurchaseMinimumMoney(int purchaseMoney) {
        if (purchaseMoney < PURCHASE_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_MONEY_MINIMUMBER_MONEY.getErrorMessage());
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumList) {
        if (winningNumList.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    // func


    public int calculatePurchaseAmount(int purchaseMoney) {
        validatePurchase(purchaseMoney);

        return purchaseMoney / PURCHASE_PRICE;
    }


    public List<Lotto> createLottoMember(int purchaseAmount) {
        List<Lotto> selectedLottoNumber = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> member = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_FRONT, LOTTO_NUMBER_RANGE_BACK, LOTTO_LIST_SIZE);
            Lotto lotto = new Lotto(member);
            selectedLottoNumber.add(lotto);
        }
        return selectedLottoNumber;
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
