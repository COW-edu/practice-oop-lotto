package domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class Customer {

    private int payment;
    private List<Integer> selectNumber;
    private int bonusNumber;

    public Customer() {

    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public void setSelectNumber(List<Integer> selectNumber) {
        this.selectNumber = selectNumber;
    }

    public List<Integer> getSelectNumber() {
        return selectNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
