package lotto.model;

public enum WinRewardData {
    THREE_ACCORD_REWARD(5000),
    FOUR_ACCORD_REWARD(50000),
    FIVE_ACCORD_REWARD(1500000),
    BONUS_ACCORD_REWARD(30000000),
    SIX_ACCORD_REWARD(2000000000);

    private final int data;

    WinRewardData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
