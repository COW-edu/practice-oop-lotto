package lotto.Service;

public class Check {
    static final int price = 1000;

    public boolean checkMoney(int money) {
        return money % price == 0;
    }

    public boolean checkNumber(int num) {
        return num >= 1 && num <= 45;
    }
}