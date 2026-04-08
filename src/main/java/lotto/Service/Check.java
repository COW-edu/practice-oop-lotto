package lotto.Service;

public class Check {

    public boolean checkMoney(int money) {
        return money % 1000 == 0;
    }

    public boolean checkNumber(int num) {
        return num >= 1 && num <= 45;
    }
}