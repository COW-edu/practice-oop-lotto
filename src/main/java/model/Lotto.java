package model;

import camp.nextstep.edu.missionutils.Randoms;
import valueObject.ErrorMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//
public class Lotto {
    private final List<Integer> numbers;;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String SPLITER = ",";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int MIN_PRICE = 0;

    public Lotto(String numberString, int bonusNumber) {
        List<Integer> numbers = split(numberString);
        validate(numbers, bonusNumber);
        this.numbers = numbers;
    }
    // String 분리하여 배열에 저장하고 배열을 리턴하는 메서드
    public List<Integer> split(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(SPLITER);
        for (String num : number) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }
    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < MIN_NUM || bonusNumber > MAX_NUM) {
            throw new NumberFormatException();
        }
    }
}
