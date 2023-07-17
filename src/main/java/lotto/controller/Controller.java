package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.model.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.Wallet;
import lotto.view.InputView;
import lotto.view.ViewText;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<Lotto> lottoList = new ArrayList<>();
        int purchaseAmount = purchaseLotto(lottoList);
        Wallet wallet = getNumbers(lottoList, purchaseAmount);
        displayStatistics(wallet);
    }

    public List<Integer> readWinNumber() {
        String winNumberLine = inputView.readString();
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

    public int readBonusNumber() {
        return inputView.readInteger();
    }

    private int purchaseLotto(List<Lotto> lottoList) {
        int purchaseAmount = calculatePurchasePrice();

        outputView.printPurchaseAmountMessage(purchaseAmount);

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            outputView.printLotto(lotto);
        }

        return purchaseAmount;
    }

    private int calculatePurchasePrice() {
        int purchasePrice =  inputView.readInteger();
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_PRICE_UNIT.getData());
        }
        return purchasePrice / 1000;
    }

    private Wallet getNumbers(List<Lotto> lottoList, int purchaseAmount) {
        outputView.printReadWinNumbersMessage();
        List<Integer> winNumber = readWinNumber();
        outputView.printReadBonusNumbersMessage();
        int bonusNumber = readBonusNumber();

        return new Wallet(lottoList, winNumber, bonusNumber, purchaseAmount);
    }

    private void displayStatistics(Wallet wallet) {
        System.out.println(ViewText.OUTPUT_WIN_STATISTICS_TITLE.getData());
        System.out.println(ViewText.OUTPUT_DIVISION_LINE.getData());

        int[] winResult = wallet.getWinResult();

        System.out.print(ViewText.OUTPUT_THREE_ACCORD_NUMBERS.getData());
        System.out.print(winResult[0]);
        System.out.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        System.out.print(ViewText.OUTPUT_FOUR_ACCORD_NUMBERS.getData());
        System.out.print(winResult[1]);
        System.out.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        System.out.print(ViewText.OUTPUT_FIVE_ACCORD_NUMBERS.getData());
        System.out.print(winResult[2]);
        System.out.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        System.out.print(ViewText.OUTPUT_FIVE_ACCORD_NUMBERS_BONUS.getData());
        System.out.print(winResult[4]);
        System.out.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        System.out.print(ViewText.OUTPUT_SIX_ACCORD_NUMBERS.getData());
        System.out.print(winResult[3]);
        System.out.println(ViewText.OUTPUT_ACCORD_NUMBERS_TAIL.getData());

        System.out.print(ViewText.OUTPUT_TOTAL_PROFIT_RATE_HEAD.getData());
        System.out.print(wallet.getProfitRate()*100);
        System.out.println(ViewText.OUTPUT_TOTAL_PROFIT_RATE_TAIL.getData());
    }
}
