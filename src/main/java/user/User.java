package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Enum.ErrorMessage;

import static lotto.Lotto.*;

public class User {

    private int payment;

    public User() {
        // 사용자 로또 구매 후 번호 생성 및 exception 처리
    }

    public int lottoCount(int money) {
        this.payment = money;
        checkCount(payment);
        return payment/PRICE;
    }

    private void checkCount(int payment) {
        if (payment%PRICE != 0) {
            ErrorMessage.BUYINGRANGE.getExceptionMessage();
            throw new IllegalArgumentException();
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
            ErrorMessage.CATCHSTRING.getExceptionMessage();
        }
        return true;
    }

    public String getUserLottoBonus() {
        String bonusNumberStr = Console.readLine();
        return bonusNumberStr;
    }

}
