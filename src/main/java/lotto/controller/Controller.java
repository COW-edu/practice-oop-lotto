package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.model.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run() {
        Wallet wallet = new Wallet();
    }
    public int convertStringToInteger(String input) {
        int output;
        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
        }
        return output;
    }

    public List<Integer> handleWinNumber(String winNumberLine) {
        String[] winNumberLineSplit = winNumberLine.split(",");
        if (winNumberLineSplit.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
        }
        List<Integer> winNumbers = new ArrayList<>();
        for (String s : winNumberLineSplit) {
            try {
                winNumbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
            }
        }
        return winNumbers;
    }

    public int handleBonusNumber(String bonusNumberLine) {
        return convertStringToInteger(bonusNumberLine);
    }

    public void handlePurchasePrice(Wallet wallet, int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_PRICE_UNIT.getData());
        }
        wallet.setPurchasePrice(purchasePrice);
        wallet.setPurchaseAmount(purchasePrice / 1000);
    }

    public void purchaseLotto(Wallet wallet) {
        int purchaseAmount = wallet.getPurchaseAmount();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.print();
            wallet.addLotto(lotto);
        }
    }

    public void calculateWinResult(Wallet wallet) {
        List<Lotto> lottoList = wallet.getLotto();
        List<Integer> winNumber = wallet.getWinNumber();
        int bonusNumber = wallet.getBonusNumber();
        int profit = 0;

        // 3, 4, 5, 6, Bonus
        int[] winResult = {0, 0, 0, 0, 0};

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();

            int accordWinNumber = 0;
            int accordBonusNumber = 0;

            for (Integer number : numbers) {
                if (winNumber.contains(number)) {
                    accordWinNumber += 1;
                }
                if (number == bonusNumber) {
                    accordBonusNumber += 1;
                }
            }

            if (accordWinNumber >= 3) {
                if (accordWinNumber == 5 && accordBonusNumber == 1) {
                    winResult[4] += 1;
                }
                winResult[accordWinNumber - 3] += 1;
            }
        }

        profit = winResult[0]*5000 + winResult[1]*50000 + winResult[2]*1500000 + winResult[3]*2000000000 + winResult[4]*30000000;

        wallet.setWinResult(winResult);
        wallet.setProfit(profit);
    }
}
