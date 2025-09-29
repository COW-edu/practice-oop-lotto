package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.WinningNumbers;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = Console.readLine();
        try {
            int amount = Integer.parseInt(line.trim());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String line = Console.readLine();
        List<Integer> numbers = parseNumbers(line);
        return new WinningNumbers(numbers);
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String line = Console.readLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}


