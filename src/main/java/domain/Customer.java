package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import Enum.ErrorMessage;

import static lotto.Lotto.PRICE;

public class Customer {

    private int payment;

    public Customer() {

    }

    public int lottoCount(String money) {
        convertInteger(money);
        payment = Integer.parseInt(money);
        checkCount(payment);
        return payment/PRICE;
    }

    private void checkCount(int payment) {
        if (payment%PRICE != 0) {
            String error = ErrorMessage.BUYINGRANGE.announceException();
            System.out.println(error);
            throw new IllegalArgumentException(error);
        }
    }

    public List<Integer> userLottoNumber(String userLottoString) {
        String[] selectNumber = userLottoString.split(",");

        return Arrays.stream(selectNumber)
                .filter(this::convertInteger)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean convertInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.CATCHSTRING.announceException());
        }
        return true;
    }

    public String getUserLottoBonus() {
        String bonusNumberStr = Console.readLine();
        return bonusNumberStr;
    }

}
