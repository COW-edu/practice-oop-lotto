package lotto.Service;

public class Check {
    public boolean checkMoney(int money) {
        if ((money % 1000) == 0)
            return true;
        return false;
    }

    public boolean checkNumber(int num) {
        if (1 <= num && num <= 45) {
            return true;
        }
        return false;
    }
}
