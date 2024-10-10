package model;

import java.util.ArrayList;
import java.util.List;

//
public class LottoImpl implements Lotto {
    private final List<Integer> numbers;;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String SPLITER = ",";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int MIN_PRICE = 0;

    public LottoImpl(String winningNumbers, int bonusNumber) {
        List<Integer> numbers = split(winningNumbers);
        validate(numbers, bonusNumber);
        this.numbers = numbers;
    }
    public List<Integer> split(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(SPLITER);
        for (String num : number) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }
    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() > LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < MIN_NUM || bonusNumber > MAX_NUM) {
            throw new NumberFormatException();
        }
    }
}
