package controller;

import model.WinningLotto;

import java.util.Collections;
import java.util.List;

public class WinningLottoFactory {

    public WinningLotto makeWinning(List<Integer> numbers, int bonus) {
        return new WinningLotto(numbers, bonus);
    }
}
