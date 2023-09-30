package user;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoSeller;

import java.util.List;

public class User {
    private LottoSeller lottoSeller;
    public User() {
        this.lottoSeller = new LottoSeller();
        order();
    }
    private String choiceAmount() {
        return Console.readLine();
    }

    private void order() {
        List<Lotto> aaa = this.lottoSeller.buyLottoes(choiceAmount());
        for(Lotto a : aaa) {
            for (int b : a.getNumbers()) {
                System.out.print(b + ",");
            }
            System.out.println();
        }
    }
}
