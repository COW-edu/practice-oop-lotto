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
        String input = writeWinNumber();
        String[] splitInput = splinterLottoNumber(input);

        if (splitInput.length != 6) {throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");}

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String numStr : splitInput) {
            int num = parseToInt(numStr.trim());

            if (num < 1 || num > 45) {throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");}
            if (!uniqueNumbers.add(num)) {throw new IllegalArgumentException("로또 번호에는 중복된 숫자가 있을 수 없습니다.");}

            lottoWinNumber.add(num);
        }

        bounsNumberCreate();
    }

    private String writeWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    private String[] splinterLottoNumber(String input) {
        return input.split(",");
    }

    private void bounsNumberCreate() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        int bonus = parseToInt(input);

        if (bonus < 1 || bonus > 45) {throw new IllegalArgumentException("보너스 번호는 1부터 45 사이여야 합니다.");}
        if (lottoWinNumber.contains(bonus)) {throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");}

        bounsNumber = bonus;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public List<Integer> getLottoWinNumber() {
        return lottoWinNumber;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
