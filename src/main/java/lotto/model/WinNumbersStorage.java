package lotto.model;

import java.util.List;

interface WinNumbersStorage {

  List<Integer> getWinNumbers();

  int getBonusNumber();
}
