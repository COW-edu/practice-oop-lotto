package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumberRepository {

    private static List<Integer> winningLottoNumbersList = new ArrayList<>();

    public List<Integer> saveWinningLottoNumbers(List<Integer> winningNumbers) {
        winningLottoNumbersList = winningNumbers;
        return winningLottoNumbersList;
    }

    public List<Integer> saveBonusNumber(int bonusNumber) {
        winningLottoNumbersList.add(bonusNumber);
        return winningLottoNumbersList;
    }

    public List<Integer> findWinningLottoNumbersList() {
        return winningLottoNumbersList;
    }
}
