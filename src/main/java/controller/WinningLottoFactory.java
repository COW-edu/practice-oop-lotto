package controller;

import model.WinningLotto;

import java.util.Collections;
import java.util.List;

public class WinningLottoFactory {
    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public WinningLotto makeWinning(List<Integer> numbers, int bonus) {
        numbers = sortNumbers(numbers);
        return new WinningLotto(numbers, bonus);
    }
}
