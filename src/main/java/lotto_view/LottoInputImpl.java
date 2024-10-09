package lotto_view;

import lotto_model.Lotto;
import lotto_model.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static lotto_exception.ErrorMessage.*;


public class LottoInputImpl implements LottoInput{
    Scanner sc = new Scanner(System.in);

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = sc.nextInt();
        if (bonusNumber < Unit.MIN_NUMBER.getValue() || bonusNumber > Unit.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getErrorMessage());
        }
        return bonusNumber;

    }

    @Override
    public int getInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int inputMoney = sc.nextInt();
        if (inputMoney % Unit.UNIT_MONEY.getValue() != 0) {
            throw new IllegalArgumentException(OUT_OF_UNIT.getErrorMessage());
        }
        return inputMoney;
    }

    @Override
    public Lotto inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String inputNum = sc.next();
        String[] targetNum = inputNum.split(",");
        for (String num : targetNum) {
            int addNumber = Integer.parseInt(num.trim());
            if (addNumber > Unit.MAX_NUMBER.getValue()) {
                throw new NumberFormatException(OUT_OF_RANGE.getErrorMessage());
            }
            if (numbers.contains(addNumber)){
                throw new NumberFormatException(DUPLICATE_NUMBER.getErrorMessage());
            }
            numbers.add(addNumber);
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
