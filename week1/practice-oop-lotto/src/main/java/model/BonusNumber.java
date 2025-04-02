package model;

public class BonusNumber implements MModel<Integer>{
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    @Override
    public Integer getData() {
        return number;
    }
}
