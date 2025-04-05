package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class LottoWinNumberCreater {
    private List<Integer> lottoWinNumber;
    private int bounsNumber;

    public LottoWinNumberCreater() {
        this.lottoWinNumber = new ArrayList<>();
    }

    public void createLottoWinNumber() {
        System.out.println();
        String input = readWinNumber();
        String[] splitInput = splitLottoNumber(input);

        if (splitInput.length != 6) {throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);}

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String numStr : splitInput) {
            int num = parseToInt(numStr.trim());

            if (num < 1 || num > 45) {throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE);}
            if (!uniqueNumbers.add(num)) {throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);}

            lottoWinNumber.add(num);
        }

        createBonusNumber();
    }

    private String readWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    private String[] splitLottoNumber(String input) {
        return input.split(",");
    }

    private void createBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        int bonus = parseToInt(input);

        if (bonus < 1 || bonus > 45) {throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_RANGE);}
        if (lottoWinNumber.contains(bonus)) {throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE);}

        bounsNumber = bonus;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS_ALLOWED);
        }
    }

    public List<Integer> getLottoWinNumber() {
        return new ArrayList<>(lottoWinNumber);
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
