package lotto.view;

import lotto.domain.Lottos;

public class OutputLottoList {
    public static void printLottoList(Lottos lottos) {
        int lottoSize = lottos.getLottos().size();
        for (int i = 0; i < lottoSize; i++) {
            System.out.println(lottos.getLottoNumber(i));
        }
        System.out.println();
    }
}
