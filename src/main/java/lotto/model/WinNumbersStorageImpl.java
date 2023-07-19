package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinNumbersStorageImpl implements WinNumbersStorage {
    List<Integer> winNumbers = new ArrayList<>();
    int bonusNumber;

    WinNumbersStorageImpl(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public List<Integer> getWinNumbers() {
        return null;
    }

    @Override
    public int getBonusNumber() {
        return 0;
    }
}
