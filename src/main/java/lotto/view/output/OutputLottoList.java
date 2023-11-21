package lotto.view.output;

import lotto.model.Lottos;

public class OutputLottoList {
    public void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }
}