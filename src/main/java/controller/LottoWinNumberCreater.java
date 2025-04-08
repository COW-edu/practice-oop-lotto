package controller;

import lotto.ErrorMessage;
import view.InputView;
import java.util.*;

public class LottoWinNumberCreater {
    private final InputView inputView;
    private List<Integer> lottoWinNumber;
    private int bounsNumber;

    public LottoWinNumberCreater(InputView inputView) {
        this.inputView = inputView;
        this.lottoWinNumber = new ArrayList<>();
    }

    public void readWinNumbers() {
        String input = inputView.inputWinNumbers();
        String[] splitInput = input.split(",");

        if (splitInput.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String numStr : splitInput) {
            int num = parseToInt(numStr.trim());

            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE);
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
            }

            lottoWinNumber.add(num);
        }

        String bonusInput = inputView.inputBonusNumber();
        int bonus = parseToInt(bonusInput);

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_RANGE);
        }
        if (lottoWinNumber.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE);
        }

        this.bounsNumber = bonus;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS_ALLOWED);
        }
    }

    public List<Integer> getWinNumbers() {
        return new ArrayList<>(lottoWinNumber);
    }

    public int getBonus() {
        return bounsNumber;
    }
}
