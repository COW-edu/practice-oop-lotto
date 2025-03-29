package controller;

import camp.nextstep.edu.missionutils.Randoms;
import global.enums.ErrorMessage;
import model.LottoNumber;
import model.WinningNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private WinningNumber winningNumber;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = handlePurchaseAmount(); // 입력 및 검증
        int numberOfLottos = calculateNumberOfLottos(purchaseAmount);
        outputView.printPurchaseCount(numberOfLottos);

        List<LottoNumber> lottoNumbers = generateRandomLottos(numberOfLottos);
        outputView.printLottoNumbers(lottoNumbers);

        getValidatedWinningNumbers();
    }

    private int handlePurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        try {
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
            }
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount/1000;
    }

    private List<LottoNumber> generateRandomLottos(int numberOfLottos) {
        List<LottoNumber> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoList.add(new LottoNumber(randomNumbers));
        }
        return lottoList;
    }

    private void getValidatedWinningNumbers() {
        while (true) {
            try {
                String input = inputView.getWinningNumber();
                saveWinningNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void saveWinningNumber(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
                }
                numbers.add(number);
            }
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_LENGTH.getMessage());
            }
            this.winningNumber = new WinningNumber(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNINT_NUMBER_IS_NOT_NUMBER.getMessage());
        }
    }
}
