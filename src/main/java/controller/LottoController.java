package controller;

import model.LottoImpl;
import model.UserLottoImpl;
import model.WinCheckerImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LottoController {
    void run();
    List<List<Integer>> getUserLottoList(int money);
    List<Integer> getWinningLotto(String winningNumbers, int bonusNumber);
    Map<Integer, Integer> checkWin(List<List<Integer>> userLottoList, List<Integer> winningLotto, int bonusNumber);
}

