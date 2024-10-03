package lottoView;

import lottoModel.Lotto;
import lottoModel.UNIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class LottoInput {
    Scanner sc = new Scanner(System.in);

    public int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = sc.nextInt();
        if (bonusNumber < UNIT.MIN_NUMBER || bonusNumber > UNIT.MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자를 입력해 주세요.");
        }
        return bonusNumber;

    }

    public int getInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int inputMoney = sc.nextInt();
        if (inputMoney % UNIT.UNIT_MONEY != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
        return inputMoney;
    }

    public Lotto inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String inputNum = sc.next();
        String[] targetNum = inputNum.split(",");
        for (String num : targetNum) {
            int addNumber = Integer.parseInt(num.trim());
            if (addNumber > UNIT.MAX_NUMBER) {
                throw new NumberFormatException("[ERROR] 1번에서 45번 이내의 숫자를 입력해 주세요.");
            }
            if (numbers.contains(addNumber)){
                throw new NumberFormatException("[ERROR] 중복된 숫자가 입력되었습니다.");
            }
            numbers.add(addNumber);
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
