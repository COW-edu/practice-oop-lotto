package lotto;

public enum Grade {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private int score;
    private int reward;
    Grade(int score, int reward) {
        this.score = score;
        this.reward = reward;
    }
    public int getScore() {
        return score;
    }
    public int getReward() {
        return reward;
    }
}
