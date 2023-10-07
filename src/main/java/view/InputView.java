package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";

    public int requestAmount() {
        String input = Console.readLine();
        int amount = checkIsNumber(input);
        checkUnit(amount);
        checkMinimum(amount);
        return amount;
    }

    public List<Integer> requestWinning() {
        String input = Console.readLine();
        List<Integer> numbers = splitNumber(input);
        checkDuplication(numbers);
        checkBoundary(numbers);
        return numbers;
    }

    public int requestBonus(List<Integer> numbers) {
        String input = Console.readLine();
        int bonus = checkIsNumber(input);
        checkDuplication(numbers, bonus);
        checkBoundary(bonus);
        return bonus;
    }

    private int checkIsNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자여야 합니다");
        }
    }

    private void checkMinimum(int amount) {
        if(amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다");
        }
    }

    private void checkUnit(int amount) {
        if(amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다");
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다");
        }
    }

    private void checkDuplication(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
    }

    private void checkBoundary(List<Integer> numbers) {
        if(Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다");
        }
    }

    private void checkBoundary(int number) {
        if(number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다");
        }
    }

    private List<Integer> splitNumber(String input) {
        String[] numberList = input.split(SEPARATOR);
        List<Integer> numbers = new ArrayList<Integer>();

        for(String number : numberList) {
            numbers.add(checkIsNumber(number));
        }

        return numbers;
    }
}
