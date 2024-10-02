package lottoView;

import lottoModel.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static lottoModel.LottoRank.*;
import static lottoModel.LottoRank.FIRST;

public class LottoViewer {
    Scanner sc = new Scanner(System.in);

    public int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = sc.nextInt();
        return bonusNum;
    }

    public int getInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int inputMoney = sc.nextInt();
        return inputMoney;
    }

    public Lotto inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String inputNum = sc.next();
        String[] targetNum = inputNum.split(",");
        for (String num : targetNum) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        Collections.sort(numbers); //어떻게 입력 받든 정렬하기.
        return new Lotto(numbers);//사용자 로또 저장 후 반환
    }

    public void print(int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원)" + FIFTH.getQuantity() + "개");
        System.out.println("4개 일치 (50,000원)" + FOURTH.getQuantity() + "개");
        System.out.println("5개 일치 (1,500,000원)" + THIRD.getQuantity() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + SECOND.getQuantity() + "개");
        System.out.println("6개 일치 (1,000,000,000원)" + FIRST.getQuantity() + "개");


        double totalPrice = (FIFTH.getLottoTotalPrize() + FOURTH.getLottoTotalPrize() + THIRD.getLottoTotalPrize() + SECOND.getLottoTotalPrize() + FIRST.getLottoTotalPrize()) / inputMoney * 100;


        System.out.println("총 수익률은 " + totalPrice + "% 입니다.");
    }

}
