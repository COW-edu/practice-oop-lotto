package lotto;

public class CheckNumber implements Check{

    @Override
    public boolean checkNum(int num) {
        if (1 <= num && num <= 45) {
            return true;
        }
        return false;
    }
}
