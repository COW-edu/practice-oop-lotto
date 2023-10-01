package lotto;

public class winningChecker {
    private Winning winning;
    public winningChecker() {
    }
    private int getScore(Lotto lotto) {
        int score = 0;
        for(int a : lotto.getNumbers()) {
            for(int b : winning.getNumbers()) {
                if(a==b) {
                    score++;
                }
            }
        }
        return score;
    }

}
