package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;
    private final OutputHandler outputHandler;

    private List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        validateWinningNumbersCount(tokens);

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            validateNumberRange(number);
            numbers.add(number);
        }

        validateNoDuplicates(numbers);
        return numbers;
    }

    private int parseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input.trim());
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private void validateMoney(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) < LottoGame.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요. 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateWinningNumbersCount(String[] tokens) {
        if (tokens.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < BONUS_NUMBER_MIN || number > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public InputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public int getMoney() {
        outputHandler.printInputPrompt("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        outputHandler.printInputPrompt("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        outputHandler.printInputPrompt("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseBonusNumber(input, winningNumbers);
    }


}
