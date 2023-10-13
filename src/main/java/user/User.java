package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import Enum.ErrorMessage;

import static lotto.Lotto.*;

public class User {

    private int payment;

    public User() {
        // 사용자 로또 구매 후 번호 생성 및 exception 처리
    }

    public int lottoCount(int money) {
        // TODO 입력의 책임과 고객에 대한 데이터 관리 및 로직 처리 분리
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

    public String[] getUserLotto() {
        String numberLine = Console.readLine();
        String[] selectNumber = numberLine.split(",");
        return selectNumber;
    }

    public List<Integer> userLottoNumber(String[] userLottoString) {
        outOfLottoLength(userLottoString);
        List<Integer> buyerNumbers = new ArrayList<>();
        for (String checkedInput: userLottoString) {
            if(convertInteger(checkedInput)) {
                buyerNumbers.add(Integer.parseInt(checkedInput));
            }
        }
        return buyerNumbers;
    }

    private void outOfLottoLength(String[] selectNumber) {
        if (selectNumber.length != COUNT_RANGE) {
            ErrorMessage.LOTTOLENGTH.getExceptionMessage();
        }
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
