package model;

public class ProfitRate implements MModel<Double> {
    private final double rate;

    public ProfitRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Double getData() {
        return rate;
    }
}