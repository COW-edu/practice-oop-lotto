package lotto;

public class CheckMoney implements Check{

    @Override
    public boolean checkNum(int money) {
        if ((money % 1000) == 0)
            return true;
        return false;
    }
}
