package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.model.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.Wallet;
import lotto.view.View;
import lotto.view.ViewText;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run() {
        Wallet wallet = new Wallet();
        View view = new View();

        view.println(ViewText.INPUT_PURCHASE_PRICE.getData());
        view.getPurchasePrice(wallet);
        view.print(wallet.getPurchaseAmount());
        view.println(ViewText.OUTPUT_PURCHASE_AMOUNT.getData());

        purchaseLotto(wallet);
        for (Lotto lotto : wallet.getLotto()) {
            lotto.print();
        }

        view.println(ViewText.INPUT_WIN_NUMBER.getData());
        wallet.setWinNumber(view.getWinNumber());
        view.println(ViewText.INPUT_BONUS_NUMBER.getData());
        wallet.setBonusNumber(view.getBonusNumber());

        calculateWinResult(wallet);
        view.println(ViewText.OUTPUT_WIN_STATISTICS_TITLE.getData());
        view.println(ViewText.OUTPUT_DIVISION_LINE.getData());

        int[] winResult = wallet.getWinResult();

        view.print(ViewText.OUTPUT_THREE_ACCORD_NUMBERS.getData());
        view.print(winResult[0]);
        view.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        view.print(ViewText.OUTPUT_FOUR_ACCORD_NUMBERS.getData());
        view.print(winResult[1]);
        view.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        view.print(ViewText.OUTPUT_FIVE_ACCORD_NUMBERS.getData());
        view.print(winResult[2]);
        view.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        view.print(ViewText.OUTPUT_FIVE_ACCORD_NUMBERS_BONUS.getData());
        view.print(winResult[4]);
        view.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        view.print(ViewText.OUTPUT_SIX_ACCORD_NUMBERS.getData());
        view.print(winResult[3]);
        view.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        view.print(ViewText.OUTPUT_TOTAL_PROFIT_RATE_HEAD.getData());
        view.print(wallet.getProfitRate());
        view.println(ViewText.OUTPUT_TOTAL_PROFIT_RATE_TAIL.getData());
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

    public void handlePurchasePrice(Wallet wallet, String purchasePriceString) {
        int purchasePrice = convertStringToInteger(purchasePriceString);
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

        int profit = winResult[0]*5000 + winResult[1]*50000 + winResult[2]*1500000 + winResult[3]*2000000000 + winResult[4]*30000000;

        wallet.setWinResult(winResult);
        wallet.setProfit(profit);
    }
}
