package lotto.Message;

public enum ResultMessage {
    THREE_CORRECT(3, "", "5,000"),
    FOUR_CORRECT(4, "", "50,000"),
    FIVE_CORRECT(5, "", "1,500,000"),
    FIVE_WITH_BONUS_CORRECT(5, ", 보너스 볼 일치", "30,000,000"),
    SIX_CORRECT(6, "", "2,000,000,000");

    private final int  winningCount;
    private final String winningMoney;
    private final String bonusComment;
    ResultMessage(int winningCount, String bonusComment, String winningMoney) {
        this.winningCount = winningCount;
        this.bonusComment = bonusComment;
        this.winningMoney = winningMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public String getBonusComment() {
        return bonusComment;
    }

    public String getWinningMoney() {
        return winningMoney;
    }

    public static ResultMessage valueOf(int winningCount) {
        if (winningCount == 3) {
            return THREE_CORRECT;
        }
        if (winningCount == 4) {
            return FOUR_CORRECT;
        }
        if (winningCount == 5) {
            return FIVE_CORRECT;
        }
        if (winningCount == 6) {
            return FIVE_WITH_BONUS_CORRECT;
        }
        return SIX_CORRECT;
    }
}
