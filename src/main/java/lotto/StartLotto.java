package lotto;

import java.util.List;

public class StartLotto {
  public StartLotto() {
    int inputPrice = InputNums.price();

    MakeLottoLists makeLottoLists = new MakeLottoLists();

    makeLottoLists.makeInputLottoList(inputPrice);

    List<List<Integer>> list = makeLottoLists.makeWinLottoList();

    InputNums.winningNums();
    InputNums.bonusNum();
  }
}
