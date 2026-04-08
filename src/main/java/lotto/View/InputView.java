package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Controller.LottoController;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final LottoController lottoController = new LottoController();

    // 구입 금액 입력
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int money = Integer.parseInt(Console.readLine());
                if (!lottoController.checkMoney(money)) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
                }
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력
    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                String[] tokens = input.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String token : tokens) {
                    int num = Integer.parseInt(token.trim());
                    if (!lottoController.checkNumber(num)) {
                        throw new IllegalArgumentException("[ERROR] 번호는 1~45 사이여야 합니다.");
                    }
                    numbers.add(num);
                }
                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                if (numbers.stream().distinct().count() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
                }
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력
    public int inputBonus(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonusNum = Integer.parseInt(Console.readLine());
                if (!lottoController.checkNumber(bonusNum)) {
                    throw new IllegalArgumentException("[ERROR] 번호는 1~45 사이여야 합니다.");
                }
                if (winningNumbers.contains(bonusNum)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}