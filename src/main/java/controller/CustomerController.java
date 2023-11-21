package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Customer;
import lotto.Lotto;

import java.util.List;

public class CustomerController {

    private static int count;
    private static int userBonusNumber;

    private Lotto selectLotto;
    private Customer customer;

    public CustomerController(Customer customer) {
        this.count = 0;
        this.customer = customer;
    }

    public int buyingLotto() {
        count = customer.lottoCount(Console.readLine());
        return count;
    }

    public List<Integer> selectLottoNumber() {
        List<Integer> selectNum = customer.userLottoNumber((Console.readLine()));
        return selectNum;
    }

    public String selectBonusNumber() {
        String userBonusStr = customer.getUserLottoBonus();
        return userBonusStr;
    }
}
