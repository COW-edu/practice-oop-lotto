package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.LottoMessage;

import java.util.ArrayList;
import java.util.List;

public class WinLottoView {

    public List<Integer> inputWinningNumbers() {
        System.out.println(LottoMessage.INPUT_WINNING_NUMBERS);
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
