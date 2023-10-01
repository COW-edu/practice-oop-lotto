package user;

import camp.nextstep.edu.missionutils.Console;
import lotto.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private LottoSeller lottoSeller;
    private List<Lotto> lottoes;
    private WinningChecker winningChecker;
    public User() {
        this.lottoSeller = new LottoSeller();
        order();
        Winning winning = initWinning();
        checkWinning(winning);
        checkReward();
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
        this.lottoes = this.lottoSeller.buyLottoes(choiceAmount());
        System.out.println("\n" + lottoes.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoes) {
            showNum(lotto.getNumbers());
        }
    }
    private Winning initWinning() {
        WinningMaker winningMaker = new WinningMaker();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        Winning winning = winningMaker.makeWinning(Console.readLine());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        winningMaker.setBonus(winning, Console.readLine());
        return winning;
    }
    private void checkWinning(Winning winning) {
        this.winningChecker = new WinningChecker(winning);
        for(Lotto lotto : lottoes) {
            winningChecker.setGrades(lotto);
        }
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + winningChecker.getGradeQuantity(Grade.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningChecker.getGradeQuantity(Grade.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningChecker.getGradeQuantity(Grade.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningChecker.getGradeQuantity(Grade.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningChecker.getGradeQuantity(Grade.FIRST) + "개");
    }
    private void checkReward() {
        double reward = 0;
        List<Grade> grades = winningChecker.getGrades();
        for(Grade grade : grades) {
            reward = reward + grade.getReward();
        }
        System.out.println("총 수익률은 " + Math.round((reward / (lottoes.size() * 10)) * 100) / 100.0 + "%입니다.");
    }
}
