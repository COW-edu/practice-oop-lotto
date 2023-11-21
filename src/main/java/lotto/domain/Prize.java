package lotto.domain;

public enum Prize {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);


    private int winningCount;
    private int winningMoney;
    private boolean isBonus;


    private Prize(int winningCount, int winningMoney, boolean isBonus) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }
}
