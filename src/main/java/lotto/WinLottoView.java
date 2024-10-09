package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinLottoView {

    public List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = "당첨 번호를 입력해주세요.";
        System.out.println(inputWinningNumbers);
        List<Integer> winningNumbers = parseInputNumbers(Console.readLine());
        new Lotto(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> parseInputNumbers(String winningNumbers) {
        String[] split = winningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            int number = Integer.parseInt(s.trim());
            numbers.add(number);
        }
        return numbers;
    }
}
