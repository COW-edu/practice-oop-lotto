package user;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoSeller;
import lotto.WinningMaker;

import java.util.List;

public class User {
    private LottoSeller lottoSeller;
    public User() {
        this.lottoSeller = new LottoSeller();
        order();
        checkWinning();
    }
    private String choiceAmount() {
        return Console.readLine();
    }
    private void showNum(List<Integer> numbers) {
        int count = 0;
        System.out.print("[" + numbers.get(count));
        count++;
        while (count < numbers.size()) {
            System.out.print(", " + numbers.get(count));
            count++;
        }
        System.out.println("]");
    }
    private void order() {
        System.out.println("구입금액을 입력해 주세요.");
        List<Lotto> lottoes = this.lottoSeller.buyLottoes(choiceAmount());
        System.out.println("\n" + lottoes.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoes) {
            showNum(lotto.getNumbers());
        }
    }
    private void checkWinning() {
        WinningMaker winningMaker = new WinningMaker();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningMaker.makeWinning(Console.readLine());
    }
}
