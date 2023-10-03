package lotto.config;

public enum WinningPrint {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);


    private int winningCount;
    private int winningMoney;
    private boolean isBonus;

    private WinningPrint(int winningCount, int winningMoney, boolean isBonus) {
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
