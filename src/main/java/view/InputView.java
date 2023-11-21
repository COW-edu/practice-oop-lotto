package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";

    public int requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = checkIsNumber(input);
        checkMinimum(amount);
        checkUnit(amount);
        return amount;
    }

    public List<Integer> requestWinning() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = splitNumber(input);
        return numbers;
    }

    public int requestBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return checkIsNumber(input);
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

    private List<Integer> splitNumber(String input) {
        List<String> numberList = List.of(input.split(SEPARATOR));
        List<Integer> numbers = new ArrayList<Integer>();

        numberList.stream()
                .map(this::checkIsNumber)
                .forEach(numbers::add);

        return numbers;
    }
}
