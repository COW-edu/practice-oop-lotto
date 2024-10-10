package view;

import model.lotto.Lotto;
import model.lotto.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static exception.ErrorMessage.*;


public class LottoInputImpl implements LottoInput {
    Scanner sc = new Scanner(System.in);
    private final List<Integer> numbers = new ArrayList<>();

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
        String inputNumber = readLine();
        String[] targetNum = inputNumber.split(",");
        for (String number : targetNum) {
            int addNumber = Integer.parseInt(number.trim());
            if (addNumber > Unit.MAX_NUMBER.getValue()) {
                throw new NumberFormatException(OUT_OF_RANGE.getErrorMessage());
            }
            if (numbers.contains(addNumber)) {
                throw new NumberFormatException(DUPLICATE_NUMBER.getErrorMessage());
            }
            numbers.add(addNumber);
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = sc.nextInt();
        if (bonusNumber < Unit.MIN_NUMBER.getValue() || bonusNumber > Unit.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getErrorMessage());
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getErrorMessage());
        }
        return bonusNumber;
    }
}
