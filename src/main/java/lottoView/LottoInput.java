package lottoView;

import lottoModel.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class LottoInput {
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
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
