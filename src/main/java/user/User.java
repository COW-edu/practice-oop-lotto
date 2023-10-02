package user;

import camp.nextstep.edu.missionutils.Console;
import exception.ExceptionMessage;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> buyerNumbers;

    public User() {
        // 사용자 로또 구매 후 번호 생성 및 exception 처리
    }

    public int lottoCount() {
        String count = Console.readLine();
        int payment = Integer.parseInt(count);
        int lottoCount = checkCount(payment);
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private int checkCount(int payment) {
        if (payment%1000 != 0) {
            ExceptionMessage.outOfBuyingRange();
            throw new IllegalArgumentException();
        }
        return payment/1000;
    }

    public Lotto getUserLottoNumber() {
        String numberLine = Console.readLine();
        String[] selectNumber = numberLine.split(",");
        String[] checkNumber = outOfLottoLength(selectNumber);
        buyerNumbers = new ArrayList<>();
        for (int i=0; i<checkNumber.length;i++) {
            buyerNumbers.add(convertInteger(checkNumber[i]));
        }
        return new Lotto(buyerNumbers);
    }

    public int getUserLottoBonus() {
        String bonusNumber = Console.readLine();
        System.out.println("보너스 숫자 : " + bonusNumber);
        return convertBonusNum(bonusNumber);
    }

    private String[] outOfLottoLength(String[] selectNumber) {
        if (selectNumber.length != 6) {
            ExceptionMessage.outOfLottoLength();
        }
        return selectNumber;
    }

    private int convertInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            ExceptionMessage.catchString();
        }
        return Integer.parseInt(number);
    }

    private int convertBonusNum(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            ExceptionMessage.catchBonusNumber();
        }
        return Integer.parseInt(number);
    }


}
