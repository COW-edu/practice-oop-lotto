package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Customer;
import lotto.Lotto;
import Enum.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.PRICE;

public class CustomerController {

    private static int count;

    private Customer customer;

    public CustomerController(Customer customer) {
        this.count = 0;
        this.customer = customer;
    }

    public int buyingLotto() {
        count = lottoCount(Console.readLine());
        return count;
    }

    public int lottoCount(String money) {
        convertInteger(money);
        customer.setPayment(Integer.parseInt(money));
        checkCount(customer.getPayment());
        return customer.getPayment()/PRICE;
    }

    public List<Integer> selectLottoNumber() {
        List<Integer> selectNum = userLottoNumber((Console.readLine()));
        customer.setSelectNumber(selectNum);
        return selectNum;
    }

    public List<Integer> userLottoNumber(String userLottoString) {
        String[] selectNumber = userLottoString.split(",");

        return Arrays.stream(selectNumber)
                .filter(this::convertInteger)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int selectBonusNumber() {
        String userBonusStr = Console.readLine();
        convertInteger(userBonusStr);
        checkDuplicateBonus(Integer.parseInt(userBonusStr));
        return Integer.parseInt(userBonusStr);
    }

    private boolean convertInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.CATCHSTRING.announceException());
        }
        return true;
    }

    private void checkCount(int payment) {
        if (payment%PRICE != 0) {
            String error = ErrorMessage.BUYINGRANGE.announceException();
            System.out.println(error);
            throw new IllegalArgumentException(error);
        }
    }

    private boolean checkDuplicateBonus(int bonusNumber) {
        if(customer.getSelectNumber().contains(bonusNumber)) {
            ErrorMessage.DUPLICATEBONUS.announceException();
            throw new IllegalArgumentException();
        }
        customer.setBonusNumber(bonusNumber);
        return true;
    }
}
