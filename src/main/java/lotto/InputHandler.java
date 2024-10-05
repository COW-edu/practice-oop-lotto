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

    public int getMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    private void validateMoney(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) < LottoGame.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요. 금액은 1000원 이상이어야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input.trim());
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }
        return bonusNumber;
    }

    private List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < BONUS_NUMBER_MIN || number > BONUS_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다.");
            }
            numbers.add(number);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
        return numbers;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
