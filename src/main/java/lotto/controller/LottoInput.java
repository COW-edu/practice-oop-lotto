package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.*;
import java.util.*;

public class LottoInput {
    private List<Integer> numbers;
    private int bonusNumber;

    public LottoInput() {
        readWinningLotto();
    }

    private void readWinningLotto() {
        try {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            numbers = parseNumbers(Console.readLine());
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine().trim());
            Lotto.validate(numbers, bonusNumber);
            Lotto.overlapCheck(numbers, bonusNumber);
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_AMOUNT);
        }
    }

    private List<Integer> parseNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}