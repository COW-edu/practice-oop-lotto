package lotto.view.output;

import lotto.domain.Lottos;

public class OutputLottoList {
    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }
}