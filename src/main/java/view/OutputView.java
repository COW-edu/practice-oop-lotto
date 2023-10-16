package view;

import model.Grade;
import model.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String COMMA = ", ";

    private void showNumber(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPENING_BRACKET);
        numbers.stream()
                .sorted(Integer::compareTo)
                .forEach(number -> stringBuilder.append(number).append(COMMA));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(CLOSING_BRACKET);
        System.out.println(stringBuilder.toString());
    }

    public void requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showOrder(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for(Lotto lotto : lottos) {
            showNumber(lotto.getNumbers());
        }
    }

    public void requestWinning() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void requestBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void showResult(List<Grade> grades) {
        System.out.println("\n당첨 통계\n---");

        for(Grade grade : Grade.values()) {
            int gradeQuantity = Collections.frequency(grades, grade);
            System.out.println(grade.getAnnounce() + gradeQuantity + "개");
        }
    }

    public void showRewardRate(double reward) {
        System.out.println("총 수익률은 " + reward + "%입니다.");
    }
}
