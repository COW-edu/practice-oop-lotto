package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Rank determineRank(WinningLotto winningLotto) {
        int matchCount = 0;
        boolean bonus = false;

        for(int i : this.numbers) {
            if(winningLotto.getWinningNum().contains(i)){
                matchCount++;
            }
        }

        for(int i : this.numbers) {
            if(i == winningLotto.getWinningBonusNum()){
                bonus = true;
            }
        }

        return Rank.valueOf(matchCount, bonus);
    }

    public String toString(){
        return numbers.toString();
    }

}
