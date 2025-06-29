package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.domain.validator.InputValidator;
import lotto.domain.validator.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        this.winningNumbers = validateAndParseWinningNumbers(inputWinningNumbers);
    }

    private List<Integer> validateAndParseWinningNumbers(String inputWinningNumbers) {
        InputValidator.validateNotEmpty(inputWinningNumbers);
        List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers);
        WinningNumberValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        if (!inputWinningNumbers.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_SPLIT_COMMA.getMessage());
        }

        List<Integer> parsedNumbers;
        try {
            parsedNumbers = Arrays.stream(inputWinningNumbers.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }

        return parsedNumbers;
    }

    public boolean hasNumber(int inputNumber) {
        return winningNumbers.contains(inputNumber);
    }
}