package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private final OutputHandler outputHandler;
    private final InputValidator inputValidator;

    public InputHandler(OutputHandler outputHandler, InputValidator inputValidator) {
        this.outputHandler = outputHandler;
        this.inputValidator = inputValidator;
    }

    public int getMoney() {
        outputHandler.print(InputConstants.GET_MONEY_PROMPT.getMessage());
        String input = Console.readLine();
        inputValidator.validateMoney(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        outputHandler.print(InputConstants.GET_WINNING_PROMPT.getMessage());
        String input = Console.readLine();
        return parseNumbers(input);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        outputHandler.print(InputConstants.GET_BONUS_PROMPT.getMessage());
        String input = Console.readLine();
        return parseBonusNumber(input, winningNumbers);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(InputConstants.PARSING_CRITERIA.getMessage());
        inputValidator.validateWinningCount(tokens);

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            inputValidator.validateRange(number);
            numbers.add(number);
        }

        inputValidator.validateNoDupes(numbers);
        return numbers;
    }

    private int parseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input.trim());
        inputValidator.validateBonus(bonusNumber, winningNumbers);
        return bonusNumber;
    }
}
